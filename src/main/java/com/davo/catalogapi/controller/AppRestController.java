package com.davo.catalogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.domain.Provider;
import com.davo.catalogapi.exception.NotFoundException;
import com.davo.catalogapi.service.CategoryService;
import com.davo.catalogapi.service.ProductService;
import com.davo.catalogapi.service.ProviderService;


@RestController
@RequestMapping("/api/v1")
public class AppRestController {

    @Autowired
    ProductService productService;
    

    @Autowired
    ProviderService providerService;

    @Autowired
    CategoryService categoryService;
    

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(productService.findById(id));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider Not Found");
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.accepted().body(productService.save(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(Long id, Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(productService.save(product));
    }

    @GetMapping("/providers")
    public ResponseEntity<List<Provider>> getAllProviders() {
        return ResponseEntity.ok().body(providerService.findAll());
    }

    @GetMapping("/providers/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(providerService.findById(id));
        } catch (NotFoundException e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider Not Found");
        }
    }

    @PostMapping("/providers")
    public ResponseEntity<Provider> createProvider(Provider provider) {
        return ResponseEntity.accepted().body(providerService.save(provider));
    }

    @PutMapping("/providers/{id}")
    public ResponseEntity<Provider> updateProvider(Long id, Provider provider) {
        provider.setId(id);
        return ResponseEntity.ok().body(providerService.save(provider));
    }

    @DeleteMapping("/category-delete/{id}")
    public String deleteCategory( @PathVariable("id")  Long categoryId){
        categoryService.deleteById(categoryId);
        return "redirect:/categories";
    }
        
}
