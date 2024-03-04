package com.scaler.productService.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaler.productService.models.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>{

}
