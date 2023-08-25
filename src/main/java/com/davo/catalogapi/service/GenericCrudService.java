package com.davo.catalogapi.service;

import java.util.List;

import com.davo.catalogapi.exception.NotFoundException;

public interface GenericCrudService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(Long id) throws NotFoundException;
    T update(T entity);
    void deleteById(Long id);
}
