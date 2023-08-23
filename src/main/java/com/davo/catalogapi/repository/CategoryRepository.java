package com.davo.catalogapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davo.catalogapi.domain.Category;

@Repository
public interface CategoryRepository  extends CrudRepository<Category, Long>{
    
}
