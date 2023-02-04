package com.misset.rma.mapper;

import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

public interface RmaEntityMapper<T, D> {
    T fromDto(D entity);

    D toDto(T entity);

    void update(@MappingTarget T target, D source);

    default List<T> fromDto(Collection<D> dtos) {
        return dtos.stream().map(this::fromDto).toList();
    }

    default List<D> toDto(Collection<T> dtos) {
        return dtos.stream().map(this::toDto).toList();
    }
}
