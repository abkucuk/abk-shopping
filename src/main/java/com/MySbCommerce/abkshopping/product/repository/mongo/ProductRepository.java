package com.MySbCommerce.abkshopping.product.repository.mongo;

import com.MySbCommerce.abkshopping.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
