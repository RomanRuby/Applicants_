package cushing.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface ResourceService {

    @Nullable Resource get(@NotNull Long id);

    @Nullable  Resource save(@NotNull Resource resource);

    @NotNull List<Resource> getAll();

    @NotNull List<Resource> getResources();

    void delete(@NotNull Long id);

}
