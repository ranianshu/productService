package com.scaler.productService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scaler.productService.dtos.ExceptionDto;


  @ControllerAdvice 
  public class GlobalExceptionHandler {
   
	  @ExceptionHandler(NotFoundException.class) 
      public ResponseEntity<ExceptionDto> handelNotFoundException(NotFoundException notFoundException) {
	       return new ResponseEntity(new ExceptionDto(HttpStatus.NOT_FOUND,
                notFoundException.getMessage()),HttpStatus.NOT_FOUND); 
	  }
  
  }
 