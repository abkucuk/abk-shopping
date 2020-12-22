package com.MySbCommerce.abkshopping.product.services;

import com.MySbCommerce.abkshopping.product.domain.MoneyTypes;
import com.MySbCommerce.abkshopping.product.domain.Product;
import com.MySbCommerce.abkshopping.product.domain.ProductImage;
import com.MySbCommerce.abkshopping.product.domain.es.ProductEs;
import com.MySbCommerce.abkshopping.product.model.ProductResponse;
import com.MySbCommerce.abkshopping.product.model.ProductSaveRequest;
import com.MySbCommerce.abkshopping.product.model.ProductSellerResponse;
import com.MySbCommerce.abkshopping.product.repository.es.ProductEsRepository;
import com.MySbCommerce.abkshopping.product.repository.mongo.ProductRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.MySbCommerce.abkshopping.product.domain.ProductImage.ImageType.FEATURE;
import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductEsService productEsService;
    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    public Flux<ProductResponse> getAll(){
        // 1- ES den sorgular
        // 2-  Calc fieldlari isle
        // redisten ihtiyaçlarını getir.
        // 3- response nesnelerine donustur
        return productEsService.findAll().map( this::mapToDto);

    }
    private ProductResponse mapToDto(ProductEs productEs){
        if (productEs == null) {
            return null;
        }
        return ProductResponse.builder()
                .seller(ProductSellerResponse.builder().Id(productEs.getSeller().getId()).name(productEs.getSeller().getName()).build())
                .image(productImageService.getProductMainImage(productEs.getId()))
                .moneyType(MoneyTypes.USD)
                .price(productPriceService.getByMoneyType(productEs.getId(), MoneyTypes.USD))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(productEs.getId(), productEs.getPrice()))
                .available(productAmountService.getByProductId(productEs.getId()))
                .price(productPriceService.getByMoneyType(productEs.getId(), MoneyTypes.USD))
                .name(productEs.getName())
                .features(productEs.getFeatures())
                .Id(productEs.getId())
                .description(productEs.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(productEs.getId()))
                .categoryId(productEs.getCategory().getId())
                .build();





    }
    public ProductResponse save(ProductSaveRequest request ){
        // 1 - mongoya yaz
        // 2 - es guncelle
        // 3 - redisten guncelle eğer varsa gerek.
        // 4 - es'den cevap dön
        // 5 - response nesnesine cevir
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("pr001")
                .categoryId(request.getId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .productImageList(request.getImages().stream().map(item -> new ProductImage(FEATURE, item)).collect(toList()))
                .build();
        product = productRepository.save(product).block();

        return this.mapToDto(productEsService.saveNewProduct(product).block());
    }

    public Mono<Long> count() {
        return productRepository.count();
    }
}
