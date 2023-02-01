package com.misset.rma.service;

import java.util.List;

public interface RmaService<T> {

    /**
     * @return entity by GUID
     */
    T get(String id);

    /**
     * Retrieve entity by GUID and update with source information
     *
     * @return saved entity
     */
    T update(String id, T source);

    /**
     * Create new entity
     *
     * @return saved entity
     */
    T add(T source);

    /**
     * Retrieve all entities
     */
    List<T> getAll();

    /**
     * Remove all entities
     */
    void removeAll();
}
