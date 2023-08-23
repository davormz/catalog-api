package com.davo.catalogapi.service;

import java.util.List;

public interface GenericCrudService<T> {
    List<T> findAll();
    T save(T entity);
    T findById(Long id);
    T update(T entity);
    void deleteById(Long id);
}
