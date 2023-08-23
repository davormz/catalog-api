package com.davo.catalogapi.service;

import org.springframework.stereotype.Service;

import com.davo.catalogapi.domain.Provider;
import com.davo.catalogapi.repository.ProviderRepository;

@Service
public class ProviderService extends GenericCrudServiceImpl<Provider, ProviderRepository>{
    
}
