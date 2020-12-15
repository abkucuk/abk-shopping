package com.MySbCommerce.abkshopping.product.repository.mongo;

import com.MySbCommerce.abkshopping.product.domain.ProductPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductPriceRepository extends ReactiveMongoRepository<ProductPrice, String> {
}
