package com.scaler.productService.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.scaler.productService.dtos.GenericProductDto;
import com.scaler.productService.exceptions.NotFoundException;

public interface ProductService {
	
	public GenericProductDto getProductById(Long id) throws NotFoundException;
	public GenericProductDto createProduct(GenericProductDto genericProductDto);
	public List<GenericProductDto> getAllProducts();
	public GenericProductDto deleteProduct(Long id);
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);
}
