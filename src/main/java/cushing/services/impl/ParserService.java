package cushing.services.impl;

import cushing.component.ParserPracaBy;
import cushing.models.entity.Applicant;
import cushing.models.entity.Resource;
import cushing.models.entity.Vacancy;
import cushing.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author Roman Nagibov
 */
@Service
public class ParserService {

    @Autowired ParserPracaBy parserPracaBy;
    @Autowired ApplicantService applicantService;


    public Boolean parceInformation(List<Resource> resources, Vacancy vacancy) throws IOException {
        List<Applicant> applicantsList = new ArrayList<>();
        Map<String, Applicant> applicants = new HashMap<>();
        for (Resource resource : resources) {
            if (resource.getName().toString().equals("praca.by")) {
                applicants.putAll(parserPracaBy.parse(vacancy));
            }
            if (resource.equals("tut.by")) {
                //   applicants.putAll(parserPracaBy.parse(vacancy));
            }

        }

        applicantsList.addAll((Collection<? extends Applicant>) applicants.values());
        for(Applicant  applicant : applicantsList) {
            applicantService.save(applicant);

        }
        return true;
    }

}
