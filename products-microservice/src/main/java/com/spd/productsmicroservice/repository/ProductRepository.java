package com.spd.productsmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spd.productsmicroservice.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
