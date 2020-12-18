package com.MySbCommerce.abkshopping.product.repository.es;

import com.MySbCommerce.abkshopping.product.domain.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs, String> {

}
