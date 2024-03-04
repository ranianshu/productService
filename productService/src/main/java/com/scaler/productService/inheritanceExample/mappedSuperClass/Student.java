package com.scaler.productService.inheritanceExample.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_student")
public class Student extends User{

	private double psp;
	private String batch;
}
