package com.scaler.productService.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.scaler.productService.models.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{
	
	Product findByTitleAndPrice_currency(String title, String currency);
	
	@Query(value = "select * from product where title = :title", nativeQuery = true)
	Product findProductByTitle(String title);

}
