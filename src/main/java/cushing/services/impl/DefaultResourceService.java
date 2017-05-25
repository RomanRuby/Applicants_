package cushing.services.impl;

import cushing.repository.ResourceRepository;
import cushing.services.ResourceService;
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
public class DefaultResourceService implements ResourceService {

    @Autowired private ResourceRepository repository;

    @Nullable
    @Override
    public Resource get(@NotNull Long id) {
        return repository.findOne(id);
    }

    @Transactional
    @Nullable
    @Override
    public Resource save(@NotNull Resource resource) {
        return repository.save(resource);
    }

    @Override
    public void delete( @NotNull Long id) {
repository.delete(id);
    }

    @NotNull
    @Override
    public List<Resource> getAll() {
        return repository.findAll();
    }

    @NotNull
    @Override
    public  List<Resource> getResources() {
        return repository.findAll();
    }

}
