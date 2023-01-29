package com.misset.rma.utils;

public interface RmaEntityMapper<T, D> {
    T fromDto(D entity);

    D toDto(T entity);

    void update(T target, D source);
}
