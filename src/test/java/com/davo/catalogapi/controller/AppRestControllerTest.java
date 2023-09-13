package com.davo.catalogapi.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.service.CategoryService;
import com.davo.catalogapi.service.ProductService;
import com.davo.catalogapi.service.ProviderService;

//@WebMvcTest(AppRestController.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppRestControllerTest {
	
	@MockBean
    private ProductService productService;
    
    @MockBean
    private CategoryService categoryService;
    
    @MockBean
    private ProviderService providerService;

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetAllProducts() throws Exception {
        // Mocking productService to return a list of products
        when(productService.findAll()).thenReturn(List.of(new Product(), new Product()));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testGetProductById() throws Exception {
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);

        // Mocking productService to return a product with the given ID
        when(productService.findById(productId)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/{id}", productId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(productId));
    }
    
    @Test
    public void testDeleteCategory() throws Exception {
        Long categoryId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/category-delete/{id}", categoryId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the deleteById method of categoryService was called with the correct categoryId
        verify(categoryService, times(1)).deleteById(categoryId);
    }

}
