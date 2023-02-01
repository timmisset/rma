package com.misset.rma.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractRmaService<T> implements RmaService<T> {

    protected final JpaRepository<T, String> repository;

    protected AbstractRmaService(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public T get(String id) {
        return repository.getReferenceById(id);

    }

    @Override
    public T update(String id, T source) {
        validate(source);
        return repository.save(source);
    }

    /**
     * Validate the entity prior to persisting it in the repository
     */
    abstract void validate(T entityToSave);

    @Override
    public T add(T source) {
        validate(source);
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
    abstract boolean canDelete(T entityToDelete);
}
