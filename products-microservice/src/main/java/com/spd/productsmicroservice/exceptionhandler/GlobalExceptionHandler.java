package com.spd.productsmicroservice.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spd.productsmicroservice.exception.ProductNotFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> productNotFoundExceptionHandler(ProductNotFoundException exception){
		log.error("Resource Not found ,{}", exception.getMessage());
		Map<String, Object> map = new HashMap<>();
		map.put("message", exception.getMessage());
		
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}

}
