package cushing.services.impl;

import cushing.component.Parser.Parser;
import cushing.component.Parser.ParserPracaBy;
import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;
import cushing.services.ApplicantService;
import cushing.services.VacancyService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author Roman Nagibov
 */
@Service
public class ParserService {

    @Autowired private ApplicantService applicantService;
    @Autowired private VacancyService vacancyService;


    public Boolean parseInformation(List<String> resources, String vacancy) {
        for (Vacancy vacancyInTable : vacancyService.getAll()) {
            if (vacancyInTable.getName().equals(vacancy)) {
                try {
                    Set<Applicant> applicants = new HashSet<>();

                    for (String resource : resources) {
                        applicants = Resource.getByAlias(resource).parse(vacancyInTable);
                    }

                    applicantService.save(applicants);
                } catch (IOException e) {
                    return false;

                }
                return true;
            }

        }
        return false;
    }

    public List<String> getResource() {
        List<String> resources = new ArrayList<>();
        for (Resource resource : Resource.values()) {
            resources.add(resource.getAlias());
        }

        return resources;
    }

    enum Resource {
        //  TYT_BY("tut.by", new TytByParser()),
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
