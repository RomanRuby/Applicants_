package cushing.services.impl;

import cushing.component.Parser.Parser;
import cushing.component.Parser.ParserPracaBy;
import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;
import cushing.services.ApplicantService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
@Service
public class ParserService   {

    @Autowired private ParserPracaBy parserPracaBy;
    @Autowired private ApplicantService applicantService;


    public Boolean parseInformation(List<String> resources, Vacancy vacancy)  {
        try {
            List<Applicant> applicantsList = new ArrayList<>();
        Map<String, Applicant> applicants = new HashMap<>();
        for (String resource : resources) {
            Resource.getByAlias(resource).parse(vacancy);
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


    enum Resource {
        TYT_BY("tut.by", new TytByParser()),
        PRACA_BY("praca.by", new ParserPracaBy());

        @Getter
        private String alias;

        @Getter
        private Parser parser;

        Resource(String alias, Parser parser) {
            this.alias = alias;
            this.parser = parser;
        }

        static Parser getByAlias(String alias) {
            for (Resource resource : Resource.values()) {
                if (resource.getAlias().equals(alias)) {
                    return resource.getParser();
                }
            }

            throw new IllegalArgumentException("No such parser exist");
        }
    }

}
