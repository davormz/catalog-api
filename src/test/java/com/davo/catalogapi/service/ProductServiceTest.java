package com.davo.catalogapi.service;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.davo.catalogapi.domain.Product;
import com.davo.catalogapi.exception.NotFoundException;
import com.davo.catalogapi.repository.ProductRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepository repository;
	
	@Test
	public void testFindByIdSuccess() throws NotFoundException{
		Product mockProduct = new Product();
		mockProduct.setId(1L);
		doReturn(Optional.of(mockProduct)).when(repository).findById(1l);
		
		Product retunedProduct = service.findById(1l);
		
		Assertions.assertSame(mockProduct, retunedProduct);
	}
    
}
