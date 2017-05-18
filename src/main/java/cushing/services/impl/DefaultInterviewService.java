package cushing.services.impl;

import cushing.models.dictionary.Status;
import cushing.models.entity.Interview;
import cushing.repository.InterviewRepository;
import cushing.repository.StatusRepository;
import cushing.services.InterviewService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Roman Nagibov
 */
@Service
@Transactional(readOnly = true)
public class DefaultInterviewService implements InterviewService {

    @Autowired private StatusRepository statusRepository;
    @Autowired private InterviewRepository interviewRepository;


    @Nullable
    @Override
    public Interview get(@NotNull Long id) {
        return interviewRepository.findOne(id);
    }

    @NotNull
    @Override
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }

    @NotNull
    @Override
    public List<Interview> getAll() {
        return interviewRepository.findAllByIsEnabledTrue();
    }

    @Override
    public void delete(@NotNull Long id) {
        Interview interview = interviewRepository.findOne(id);
        interview.setIsEnabled(false);

        interviewRepository.save (interview);
    }

    @NotNull
    @Override
    public List<Interview> getImmediateInterviews() {
        Date currentDate = new Date();
        return  interviewRepository.findAllByIsEnabledTrueAndEventDateGreaterThan(currentDate);
    }

    @Transactional
    @Nullable
    @Override
    public Interview update(@NotNull Interview interview) {
        return interviewRepository.save(interview);
    }

    @Transactional
    @Nullable
    @Override
    public Interview saveInterview(@NotNull Interview interview) {
        interview.setIsEnabled(true);
        return interviewRepository.save(interview);
    }

    @NotNull
    @Override
    public List<Interview> getAllInterviewsByApplicants(@NotNull Long id) {
        return interviewRepository.findAllByApplicantId(id);
    }

}
