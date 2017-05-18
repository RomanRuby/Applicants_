package cushing.services;

import cushing.models.dictionary.Status;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface StatusService {

    @Nullable Status get(@NotNull Long id);

    @Nullable  Status save(@NotNull Status status);

    @NotNull List<Status> getAll();

    void delete(@NotNull Long id);

}
