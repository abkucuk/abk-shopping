package com.MySbCommerce.abkshopping.product.startup;

import com.MySbCommerce.abkshopping.product.domain.MoneyTypes;
import com.MySbCommerce.abkshopping.product.model.ProductSaveRequest;
import com.MySbCommerce.abkshopping.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;


@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)){
            IntStream.range(0, 20).forEach(i -> {
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerId(randomUUID().toString())
                                .id(randomUUID().toString())
                                .description("product + " + i)
                                .moneyTypes(MoneyTypes.USD)
                                .categoryId(randomUUID().toString())
                                .name("Product Name: " + i)
                                .features("<li>Color: Black</<li>")
                                .price(BigDecimal.TEN)
                                .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                                .build()
                );

            });
        }

    }
}
