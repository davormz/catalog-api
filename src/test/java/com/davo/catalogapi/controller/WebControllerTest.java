package com.davo.catalogapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.davo.catalogapi.domain.Category;
import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.service.CategoryService;
import com.davo.catalogapi.service.ProductService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
// @SpringJUnitWebConfig
@SpringBootTest
@AutoConfigureMockMvc
public class WebControllerTest {

    @MockBean
    private ProductService productService;
    
    @MockBean
    private CategoryService categoryService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllProductsShouldReturnOk() throws Exception {
        Product product = new Product("Product 1", 100.0);
        List<Product> products = List.of(product);
        product.setId(1L);
        doReturn(products).when(productService).findAll();

        mockMvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    public void createProductShouldReturnOk() throws Exception {
        Product product = new Product("Product 1", 100.0);
        product.setId(1L);
        doReturn(product).when(productService).save(any(Product.class));

        mockMvc.perform(post("/products")).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/products"));
    }
    
    @Test
    public void showProductFormShouldReturnOk() throws Exception {
    	Category categoryMock = new Category("Test");
    	categoryMock.setId(1L);
    	List<Category> categories = List.of(categoryMock);
    	doReturn(categories).when(categoryService).findAll();
    	
    	mockMvc.perform(get("/product-form")).andExpect(status().isOk());
    }
    
    @Test
    public void getAllCategoriesShouldReturnOk() throws Exception {
    	Category categoryMock = new Category("Test");
    	categoryMock.setId(1L);
    	List<Category> categories = List.of(categoryMock);
    	doReturn(categories).when(categoryService).findAll();
    	
    	mockMvc.perform(get("/categories")).andExpect(status().isOk());
    }
    
    @Test
    public void createCategoryShouldReturnOk() throws Exception {
    	Category categoryMock = new Category("Test");
    	categoryMock.setId(1L);
    	doReturn(categoryMock).when(categoryService).save(any());
    	
    	mockMvc.perform(post("/categories")).andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/categories"));
    }
    
}
