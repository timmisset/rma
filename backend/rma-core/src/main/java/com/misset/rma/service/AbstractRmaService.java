package com.misset.rma.service;

import com.misset.rma.utils.RmaEntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractRmaService<T, D> implements RmaService<D> {

    protected final JpaRepository<T, String> repository;
    protected final RmaEntityMapper<T, D> entityMapper;

    protected AbstractRmaService(JpaRepository<T, String> repository, RmaEntityMapper<T, D> entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public D get(String id) {
        return entityMapper.toDto(getAsType(id));
    }

    public T getAsType(String id) {
        return repository.getReferenceById(id);
    }

    @Override
    public D update(String id, D source) {
        T resource = repository.getReferenceById(id);
        entityMapper.update(resource, source);
        validate(resource);
        resource = repository.save(resource);
        return entityMapper.toDto(resource);
    }

    /**
     * Validate the entity prior to persisting it in the repository
     */
    abstract void validate(T entityToSave);

    @Override
    public D add(D source) {
        T entity = entityMapper.fromDto(source);
        validate(entity);
        T save = repository.save(entity);
        return entityMapper.toDto(save);
    }

    @Override
    public List<D> getAll() {
        return repository.findAll()
                .stream()
                .map(entityMapper::toDto)
                .toList();
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
