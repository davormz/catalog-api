package com.davo.catalogapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public class GenericCrudServiceImpl<T, R extends CrudRepository> implements GenericCrudService<T> {

    @Autowired
    protected R repository;

    @Override
    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    @Override
    // @Transactional
    public T save(T entity) {
        return (T) repository.save(entity);
    }

    @Override
    public T findById(Long id) {
        return (T) repository.findById(id);
    }

    @Override
    public T update(T entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
