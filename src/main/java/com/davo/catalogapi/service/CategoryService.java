package com.davo.catalogapi.service;

import org.springframework.stereotype.Service;

import com.davo.catalogapi.domain.Category;
import com.davo.catalogapi.repository.CategoryRepository;

@Service
public class CategoryService extends GenericCrudServiceImpl<Category, CategoryRepository> {
    
}
