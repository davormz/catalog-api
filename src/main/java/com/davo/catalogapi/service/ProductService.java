package com.davo.catalogapi.service;

import org.springframework.stereotype.Service;

import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.repository.ProductRepository;

@Service
public class ProductService extends GenericCrudServiceImpl<Product, ProductRepository>{
    
}
