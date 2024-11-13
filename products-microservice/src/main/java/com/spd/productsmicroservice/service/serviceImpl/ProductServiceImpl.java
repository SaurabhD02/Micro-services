package com.spd.productsmicroservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spd.productsmicroservice.dto.ProductDto;
import com.spd.productsmicroservice.entity.Product;
import com.spd.productsmicroservice.exception.ProductNotFoundException;
import com.spd.productsmicroservice.repository.ProductRepository;
import com.spd.productsmicroservice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	
	private ProductRepository productRepository;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
		super();
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product savedProduct = productRepository.save(product);
		log.debug("Product saved in database");
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(String productId, ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Optional<Product>  fetchedProduct = productRepository.findById(productId);
		if(fetchedProduct.isPresent()) {
			Product p = fetchedProduct.get();
			p.setProductName(productDto.getProductName());
			p.setPrice(productDto.getPrice());
			p.setCategory(productDto.getCategory());
			p.setDescription(productDto.getDescription());
			productRepository.save(p);
			
		}else {
			log.error("No product found with the productId -> {}", productId);
			throw new ProductNotFoundException("Product Not found with productId "+ productId);
		}
		
		return null;
	}

	@Override
	public ProductDto getProduct(String productId) {
		Optional<Product>  fetchedProduct = productRepository.findById(productId);
		Product p = null;
		if(fetchedProduct.isPresent()) {	
			p = fetchedProduct.get();
		}else {
			log.error("No product found with the productId -> {}", productId);
			throw new ProductNotFoundException("Product Not found with productId "+ productId);
		}
		return modelMapper.map(p, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> list = productRepository.findAll();
		return list.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteProduct(String productId) {
		productRepository.deleteById(productId);
		return "Product Deleted succesfully with productId -> "+ productId;
	}

}
