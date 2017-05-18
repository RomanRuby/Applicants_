package cushing.services.impl;

import cushing.models.entity.Vacancy;
import cushing.repository.VacancyRepository;
import cushing.services.VacancyService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Roman Nagibov
 */
@Service
@Transactional(readOnly = true)
public class DefaultVacancyService implements VacancyService {

    @Autowired private VacancyRepository repository;

    @Nullable
    @Override
    public Vacancy get(@NotNull Long id) {
        return repository.findOne(id);
    }

    @Transactional
    @Nullable
    @Override
    public Vacancy save(@NotNull Vacancy vacancy) {
        return repository.save(vacancy);
    }

    @Override
    public void delete( @NotNull Long id) {
repository.delete(id);
    }

    @NotNull
    @Override
    public List<Vacancy> getAll() {
        return repository.findAll();
    }

    @NotNull
    @Override
    public  List<Vacancy> getVacancies() {
        return repository.findAll();
    }

}
