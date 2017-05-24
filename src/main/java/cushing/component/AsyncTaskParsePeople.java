package cushing.component;

import cushing.component.impl.Jsoup.JsoupParserPracaBy;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
@Component
public class AsyncTaskParsePeople implements Scrapping {

    @Autowired private ApplicantService applicantService;
    @Autowired private JsoupParserPracaBy jsoupParserPracaBy;


    @Override
    public Map<String, String> getInformation(List<String> command) throws IOException {
        Document document = jsoupParserPracaBy.getDocumentJava();
        Elements elementsByAttributeValueStarting = document.getElementsByClass("search-list").get(0).getElementsByAttributeValueStarting("href", "http");

        List<String> applicantsList = new ArrayList<String>();
        Map<String, String> applicants = new HashMap<>();
        String applicant;
        for (Element elements : elementsByAttributeValueStarting) {

            String[] parts = elements.toString().split("\"");
            Document document_res = Jsoup.connect(parts[3]).get();
            String string = document_res.toString();
            String[] parts_1 = string.split("<meta property=\"og:description\" content=\"");
            String[] parts_2 = parts_1[1].split("\"");
            applicant = (parts_2[0] + parts[3]);
            String[] applicantDetails = "\\.".split(applicant);

            Vacancy vacancy = new Vacancy();

            vacancy.setId(1L);

            applicants.put(applicantDetails[1] + applicantDetails[2] + applicantDetails[3],
                    (applicantService.save(new Applicant(applicantDetails[0],
                            "-", null, applicantDetails[4] + applicantDetails[5],
                            applicantDetails[1] + applicantDetails[2] + applicantDetails[3], vacancy, null))).toString());

        }

        return applicants;
    }
}
