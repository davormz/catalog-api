package com.davo.catalogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.domain.Provider;
import com.davo.catalogapi.service.GenericCrudService;


@RestController
@RequestMapping("/api/v1")
public class AppRestController {

    @Autowired
    GenericCrudService<Product> productService;

    @Autowired
    GenericCrudService<Provider> providerService;
    

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(Product product) {
        return ResponseEntity.ok().body(productService.save(product));
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
    public ResponseEntity<Provider> getProviderById(Long id) {
        return ResponseEntity.ok().body(providerService.findById(id));
    }

    @PostMapping("/providers")
    public ResponseEntity<Provider> createProvider(Provider provider) {
        return ResponseEntity.ok().body(providerService.save(provider));
    }

    @PutMapping("/providers/{id}")
    public ResponseEntity<Provider> updateProvider(Long id, Provider provider) {
        provider.setId(id);
        return ResponseEntity.ok().body(providerService.save(provider));
    }

    



    public void setProductService(GenericCrudService<Product> productService) {
        this.productService = productService;
    }

        
}
