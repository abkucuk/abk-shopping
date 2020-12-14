package com.MySbCommerce.abkshopping.product.repository;

import com.MySbCommerce.abkshopping.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
