package cushing.services.impl;

import cushing.models.dictionary.Status;
import cushing.repository.StatusRepository;
import cushing.services.StatusService;
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
public class DefaultStatusService implements StatusService {

    @Autowired private StatusRepository repository;


    @Nullable
    @Override
    public Status get(@NotNull Long id) {
        return repository.findOne(id);
    }

    @Transactional
    @Nullable
    @Override
    public Status save(@NotNull Status status) {
        return repository.save(status);
    }

    @Override
    public void delete(@NotNull Long id) {
        repository.delete(id);
    }

    @NotNull
    @Override
    public List<Status> getAll() {
        return repository.findAll();
    }

}
