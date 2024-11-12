package com.spd.productsmicroservice.dto;

import lombok.Data;

@Data
public class ProductDto {
	
    private String productId;
	
	private String productName;
	
	private double price;
	
	private String category;
	
	private String description;

}
