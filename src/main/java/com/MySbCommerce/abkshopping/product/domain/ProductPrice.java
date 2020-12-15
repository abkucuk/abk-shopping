package com.MySbCommerce.abkshopping.product.domain;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;

@Document(collation = "product_price")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProductPrice {
    private String productId;
    private String Id;
    private String moneyType;
    private String code;



}
