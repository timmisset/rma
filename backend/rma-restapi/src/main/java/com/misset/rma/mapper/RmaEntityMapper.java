package com.misset.rma.mapper;

import org.mapstruct.MappingTarget;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    @ObjectFactory
    default T createNewInstance(D source, @TargetType Class<T> targetClass) {
        try {
            Method getId = source.getClass().getDeclaredMethod("getId");
            String id = (String) getId.invoke(source);
            if (id != null) {
                return targetClass.getDeclaredConstructor(String.class).newInstance(id);
            } else {
                return targetClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RmaMappingException(e);
        }
    }
}
