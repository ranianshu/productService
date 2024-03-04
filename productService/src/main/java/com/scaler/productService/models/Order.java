package com.scaler.productService.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "orders")
public class Order extends BaseModel{
	@ManyToMany
	@JoinTable(
			name="products_orders",
			joinColumns = @JoinColumn(name = "orderId"),
			inverseJoinColumns = @JoinColumn(name = "productId")
			)
	private List<Product> products;

}
