package cushing.services;

import cushing.models.entity.Applicant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface ApplicantService {

    @Nullable Applicant get(@NotNull Long id);

    @Nullable Applicant save(@NotNull Applicant applicant);

    @Nullable Applicant update(@NotNull Applicant applicant);

    @NotNull List<Applicant> getAll();

    void delete(@NotNull Long id);

}
