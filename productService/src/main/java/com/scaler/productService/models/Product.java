package com.scaler.productService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
	
	private String title;
	private String description;
	private String image;
	@ManyToOne
	private Category category;
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private Price price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [title=" + title + ", description=" + description + ", image=" + image + ", category="
				+ category + ", price=" + price + "]";
	}

}
