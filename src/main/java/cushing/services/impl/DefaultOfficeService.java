package cushing.services.impl;


import cushing.models.dictionary.Office;
import cushing.repository.OfficeRepository;
import cushing.services.OfficeService;
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
public class DefaultOfficeService implements OfficeService {

    @Autowired private OfficeRepository repository;


    @Nullable
    @Override
    public Office get(@NotNull Long id) {
        return repository.findOne(id);
    }

    @Transactional
    @Nullable
    @Override
    public Office save(@NotNull Office office) {
        return repository.save(office);
    }

    @NotNull
    @Override
    public List<Office> getOffices() {
        return repository.findAll();
    }

    @Override
    public void delete(@NotNull Long id) {
        repository.delete(id);
    }

    @NotNull
    @Override
    public List<Office> getAll() {
        return repository.findAll();
    }

}
