package com.spd.productsmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spd.productsmicroservice.constant.EndpointReferer;
import com.spd.productsmicroservice.dto.ProductDto;
import com.spd.productsmicroservice.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(EndpointReferer.PRODUCT_CONTROLLER)
@Tag(name = "Products Apis")
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") String productId, @RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.updateProduct(productId, productDto), HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> findProductById(@PathVariable("productId") String productId){
		return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> findAllProducts(){
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") String productId){
		return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
	}
	
	
	
	
	

}
