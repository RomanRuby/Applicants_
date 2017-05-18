package cushing.controllers;

import cushing.models.dictionary.Status;
import cushing.models.entity.Applicant;
import cushing.models.entity.Interview;
import cushing.services.ApplicantService;
import cushing.services.InterviewService;
import cushing.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Roman Nagibov
 */
@RestController
@RequestMapping(value = "/cushing/interviews")
public class InterviewController {

    @Autowired private InterviewService interviewService;
    @Autowired private ApplicantService applicantService;
    @Autowired private StatusService statusService;


    @RequestMapping(value = "/immediate_interviews")
    public List<Interview> getImmediateInterviews() {
        return interviewService.getImmediateInterviews();
    }

    @RequestMapping
    public List<Interview> getAll() {
        return interviewService.getAll();
    }

    @RequestMapping(value = "/statuses")
    public List<Status> getStatuses() {
        return interviewService.getStatuses();
    }

    @RequestMapping(value = "/byApplicant/{id}", method = RequestMethod.POST)
    public Interview saveInterview(@PathVariable Long id, @Valid @RequestBody Interview interview) {
        Status status = statusService.get(interview.getStatus().getId());
        interview.setApplicant(applicantService.get(id));
        interview.setStatus(status);

        return interviewService.saveInterview(interview);
    }

    @RequestMapping(value = "/byApplicant/{id}", method = RequestMethod.PUT)
    public Interview update(@PathVariable Long id, @Valid @RequestBody Interview interview) {
        Applicant applicant = applicantService.get(id);
        interview.setApplicant(applicant);
        return interviewService.update(interview);
    }

    @RequestMapping(value = "/byApplicant/{id}")
    public List<Interview> getAllInterviewsByApplicants(@PathVariable Long id) {
        return interviewService.getAllInterviewsByApplicants(id);

    }

}