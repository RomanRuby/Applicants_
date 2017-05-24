package cushing.component.Parser;

import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;
import cushing.services.ApplicantService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
@Component
public class ParserPracaBy implements Scrapping {

    @Autowired private ApplicantService applicantService;


    @Override
    public Map<String, Applicant> parse(Vacancy vacancy) throws IOException {

        Document document = null;
        Jsoup.connect(String.valueOf("https://praca.by/search/resumes/?search%5Bquery%5D="+vacancy.getName()
                +"&search%5Bquery-text-params%5D%5Bheadline%5D=1&form-submit-btn=%D0%9D%D0%B0%D0%B9%D1%82%D0%B8")).get();


        Elements elementsByAttributeValueStarting = document.getElementsByClass("search-list").
                get(0).getElementsByAttributeValueStarting("href", "http");
        Map<String, Applicant> applicants = new HashMap<>();
        for (Element elements : elementsByAttributeValueStarting) {
            String[] parts = elements.toString().split("\"");
            Document document_res = Jsoup.connect(parts[3]).get();
            String string = document_res.toString();
            String[] parts_1 = string.split("<meta property=\"og:description\" content=\"");
            String[] parts_2 = parts_1[1].split("\"");
            String  applicant = (parts_2[0] + parts[3]);
            String[] applicantDetails = "\\.".split(applicant);

            vacancy.setId(1L);
            applicants.put(applicantDetails[1] + applicantDetails[2] + applicantDetails[3],
                    (applicantService.save(new Applicant(applicantDetails[0],
                            "-", null, applicantDetails[4] + applicantDetails[5],
                            applicantDetails[1] + applicantDetails[2] + applicantDetails[3], vacancy, null))));

        }

        return applicants;
    }

}
