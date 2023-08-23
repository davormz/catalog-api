package com.davo.catalogapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davo.catalogapi.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
