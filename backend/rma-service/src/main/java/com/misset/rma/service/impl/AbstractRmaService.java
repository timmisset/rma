package com.misset.rma.service.impl;

import com.misset.rma.repository.Repository;
import com.misset.rma.service.RmaService;

import java.util.List;

public abstract class AbstractRmaService<T> implements RmaService<T> {

    protected final Repository<T> repository;

    protected AbstractRmaService(Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T get(String id) {
        return repository.getReferenceById(id);
    }

    @Override
    public T update(String id, T source) {
        canPersist(source);
        return repository.save(source);
    }

    /**
     * Validate the entity prior to persisting it in the repository
     */
    protected void canPersist(T entityToSave) {

    }

    @Override
    public T add(T source) {
        canPersist(source);
        return repository.save(source);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void removeAll() {
        repository.findAll()
                .stream()
                .filter(this::canDelete)
                .forEach(repository::delete);
    }

    /**
     * Validate that the entity can be removed safely
     */
    protected boolean canDelete(T entityToDelete) {
        return true;
    }
}
