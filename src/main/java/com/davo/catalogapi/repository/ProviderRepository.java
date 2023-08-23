package com.davo.catalogapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davo.catalogapi.domain.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long>{
    
}
