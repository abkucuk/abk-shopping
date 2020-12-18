package com.MySbCommerce.abkshopping.product.services;

import com.MySbCommerce.abkshopping.product.domain.MoneyTypes;
import com.MySbCommerce.abkshopping.product.repository.mongo.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;
    public BigDecimal getByMoneyType(String id, MoneyTypes type){
        return BigDecimal.TEN;
    }


}
