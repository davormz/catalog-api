package com.davo.catalogapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.davo.catalogapi.exception.NotFoundException;

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
    public T findById(Long id) throws NotFoundException {
        Optional<T> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new NotFoundException("Entity not found");
        }
        
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
