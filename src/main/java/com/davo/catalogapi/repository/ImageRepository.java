package com.davo.catalogapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davo.catalogapi.domain.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
    
}
