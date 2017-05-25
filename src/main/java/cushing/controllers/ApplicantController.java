package cushing.controllers;

import cushing.Loggable;
import cushing.models.dictionary.Office;
import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;
import cushing.services.ApplicantService;
import cushing.services.OfficeService;
import cushing.services.ResourceService;
import cushing.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Roman Nagibov
 */
@Loggable
@RestController
@RequestMapping(value = "/cushing/applicants")
public class ApplicantController {

    @Autowired private ApplicantService applicantService;
    @Autowired private OfficeService officeService;
    @Autowired private VacancyService vacancyService;
    @Autowired private ResourceService resourceService;


    @Loggable
    @RequestMapping
    public List<Applicant> getAll() {
        return applicantService.getAll();
    }

    @Loggable
    @RequestMapping(value = "/{id}")
    public Applicant get(@PathVariable Long id) {
        return applicantService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Applicant save(@RequestBody @Valid Applicant applicant) {
        return applicantService.save(applicant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Applicant update(@PathVariable Long id, @Valid @RequestBody Applicant applicant) {
        applicant.setId(id);
        return applicantService.update(applicant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        applicantService.delete(id);
    }

    @RequestMapping(value = "/offices")
    public List<Office> getOffices() {
        return officeService.getOffices();
    }

    @RequestMapping(value = "/vacancies")
    public List<Vacancy> getVacancies() {
        return vacancyService.getVacancies();
    }

    @RequestMapping(value = "/resources")
    public List<Resource> getResources() {
        return resourceService.getResources();
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/vacancy", method = RequestMethod.POST )
    public Vacancy setVacancy(@RequestBody Vacancy vacancy) {
        return vacancyService.save(vacancy);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/office", method = RequestMethod.POST )
    public Office setOffice(@RequestBody Office office) {
        return officeService.save(office);
    }

}
