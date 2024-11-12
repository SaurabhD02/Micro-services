package com.spd.productsmicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Product {
	
	@MongoId
	private String productId;
	
	private String productName;
	
	private double price;
	
	private String category;
	
	private String description;

}
