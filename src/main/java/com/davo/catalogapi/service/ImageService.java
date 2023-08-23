package com.davo.catalogapi.service;

import org.springframework.stereotype.Service;

import com.davo.catalogapi.domain.Image;
import com.davo.catalogapi.repository.ImageRepository;

@Service
public class ImageService extends GenericCrudServiceImpl<Image, ImageRepository>{
    
}
