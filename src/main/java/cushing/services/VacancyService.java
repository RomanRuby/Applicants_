package cushing.services;

import cushing.models.entity.Vacancy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Roman Nagibov
 */
public interface VacancyService {

    @Nullable Vacancy get(@NotNull Long id);

    @Nullable Vacancy save(@NotNull Vacancy vacancy);

    @NotNull List<Vacancy> getAll();

    @NotNull List<Vacancy> getVacancies();

    void delete(@NotNull Long id);

}
