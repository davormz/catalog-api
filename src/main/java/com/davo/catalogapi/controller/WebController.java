package com.davo.catalogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davo.catalogapi.domain.Category;
import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.service.GenericCrudService;

@Controller
public class WebController {

    @Autowired
    GenericCrudService<Product> productService;

    @Autowired
    GenericCrudService<Category> categoryService;

    @GetMapping("/products")
    public String retrieveProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product-form")
    public String products(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "product-form";
    }

    @PostMapping("/products")
    public String createProduct( @ModelAttribute Product product){
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/categories")
    public String retrieveCategories(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("allCategories", categoryService.findAll());
        return "categories";
    }

    @PostMapping("/categories")
    public String createCategory( @ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    public void setProductService(GenericCrudService<Product> productService) {
        this.productService = productService;
    }

    
}
