package cushing.services;

import cushing.models.dictionary.Status;
import cushing.models.entity.Interview;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface InterviewService {

    @Nullable Interview get(@NotNull Long id);

    @NotNull List<Interview> getAll();

    @NotNull List<Interview> getImmediateInterviews();

    @Nullable Interview saveInterview(@NotNull Interview interview);

    @NotNull List<Status> getStatuses();

    @NotNull List<Interview> getAllInterviewsByApplicants(@NotNull Long id);

    @Nullable Interview update(@NotNull Interview Interview);

    void delete(@NotNull Long id);

}
