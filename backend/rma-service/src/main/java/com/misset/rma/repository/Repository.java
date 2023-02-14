package com.misset.rma.repository;

import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    T save(T entity);

    void delete(T entity);

    void deleteAll();

    T getReferenceById(String id);

}
