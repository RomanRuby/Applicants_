package cushing.services.impl;

import cushing.component.Parser.ParserPracaBy;
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
public class ParserService   {

    @Autowired ParserPracaBy parserPracaBy;
    @Autowired ApplicantService applicantService;


    public Boolean parceInformation(List<Resource> resources, Vacancy vacancy)  {
        try {
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

        applicantsList.addAll(applicants.values());
        for(Applicant  applicant : applicantsList) {
            applicantService.save(applicant);
        }
        } catch (IOException e) {
            return false;

        }
        return true;
    }

}
