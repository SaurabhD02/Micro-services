package com.spd.productsmicroservice.service;

import java.util.List;

import com.spd.productsmicroservice.dto.ProductDto;

public interface ProductService {
	
	
	public ProductDto addProduct(ProductDto productDto);
	
	public ProductDto updateProduct(String productId, ProductDto productDto);
	
	public ProductDto getProduct(String productId);
	
	public List<ProductDto> getAllProducts();

	public String deleteProduct(String productId);


}
