package cushing.services;

import cushing.models.dictionary.Office;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface OfficeService {

    @Nullable  Office get(@NotNull Long id);

    @Nullable Office save(@NotNull Office office);

    @NotNull List<Office> getAll();

    @NotNull List<Office> getOffices();

    void delete(@NotNull Long id);

}
