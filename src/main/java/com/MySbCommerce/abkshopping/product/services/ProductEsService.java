package com.MySbCommerce.abkshopping.product.services;

import com.MySbCommerce.abkshopping.product.domain.Product;
import com.MySbCommerce.abkshopping.product.domain.es.CategoryEs;
import com.MySbCommerce.abkshopping.product.domain.es.CompanyEs;
import com.MySbCommerce.abkshopping.product.domain.es.ProductEs;
import com.MySbCommerce.abkshopping.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductEsService {
    private  final ProductEsRepository productEsRepository;

    public Mono<ProductEs> saveNewProduct(Product product){
        return  productEsRepository.save(
                    ProductEs.builder().active(product.getActive())
                            .code(product.getCode())
                            .description(product.getDescription())
                            .features(product.getFeatures())
                            .id(product.getId())
                            .name(product.getName())
                            // TODO get company name and code
                            .seller(CompanyEs.builder().Id(product.getCompanyId()).name("Test").build())
                            .category(CategoryEs.builder().Id(product.getCategoryId()).name("Test").build())
                            .build()
                );


    }
    public Flux<ProductEs> findAll(){
         return productEsRepository.findAll();
    }

}
