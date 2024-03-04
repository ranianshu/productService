package com.scaler.productService.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scaler.productService.dtos.GenericProductDto;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

	@Override
	public GenericProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericProductDto createProduct(GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericProductDto deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
