package com.scaler.productService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.productService.models.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
