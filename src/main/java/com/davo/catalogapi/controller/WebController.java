package com.davo.catalogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.service.GenericCrudService;

@Controller
public class WebController {

    @Autowired
    GenericCrudService<Product> productService;


    @GetMapping("/products")
    public String retrieveProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    public void setProductService(GenericCrudService<Product> productService) {
        this.productService = productService;
    }

    
}
