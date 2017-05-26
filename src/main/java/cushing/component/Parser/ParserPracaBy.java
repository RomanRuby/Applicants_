package cushing.component.Parser;

import cushing.models.dictionary.Office;
import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * @author Roman Nagibov
 */
@Component
public class ParserPracaBy implements Parser {

    @Override
    public Set<Applicant> parse(Vacancy vacancy) throws IOException {
        Set<Applicant> applicants = new HashSet<>();
        for (int i = 2; i < 3; i++) {
            Document document = Jsoup.connect
                    (String.valueOf("https://praca.by/search/resumes/?page=" + i + "&search[query]=" + vacancy
                    + "=3&search[query]=java&search[query-text-params][headline]=1&form-submit-btn=Найти")).get();

            Elements paths = document.getElementsByClass("search-list");
            if (paths.size() == 0) {
                break;
            }

            Elements elementsByAttributeValueStarting = paths.
                    get(0).getElementsByAttributeValueStarting("href", "http");

            for (Element elements : elementsByAttributeValueStarting) {
                String[] allInformation = elements.toString().split("\"");
                String[] commonInformation = Jsoup.connect(allInformation[3]).get().
                        toString().split("<meta property=\"og:description\" content=\"");
                String[] applicantDetails = commonInformation[1].split("\"")[0].split("\\.");

                Office office = new Office();
                office.setId(1L);

                applicants.add(new Applicant(applicantDetails[0],
                                "undefined", new Date(), allInformation[3],
                                applicantDetails[1] + applicantDetails[2], vacancy, office));

            }

        }

        return applicants;
    }

}
