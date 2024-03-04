package com.scaler.productService.inheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_student")
@DiscriminatorValue("2")
public class Student extends User{

	private double psp;
	private String batch;
	
	public double getPsp() {
		return psp;
	}
	public void setPsp(double psp) {
		this.psp = psp;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
}
