package com.scaler.productService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.productService.dtos.ExceptionDto;
import com.scaler.productService.dtos.GenericProductDto;
import com.scaler.productService.services.ProductService;
import com.scaler.productService.exceptions.NotFoundException;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(@Qualifier("fakeStoreProductService")ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<GenericProductDto> getAllProducts() {
		System.out.println("getAllProducts");
		return productService.getAllProducts();
	}
	
	@GetMapping("{id}")
	public GenericProductDto getProductById(@PathVariable Long id) throws NotFoundException {
		return productService.getProductById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto) {
		return new ResponseEntity<>(productService.updateProductById(id, genericProductDto), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable("id") Long id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK); 
	}
	
	@PostMapping()
	public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
		return productService.createProduct(genericProductDto);
    }
	
	
	  @ExceptionHandler(NotFoundException.class) public
	  ResponseEntity<ExceptionDto> handelNotFoundException(NotFoundException notFoundException) { 
		  return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),HttpStatus.NOT_FOUND); 
		  }
	 
}
