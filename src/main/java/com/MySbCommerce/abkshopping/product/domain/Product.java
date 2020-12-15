package com.MySbCommerce.abkshopping.product.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collation = "product")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product {
    private String id;
    private String name;
    private String code;
    private String description;
    private String CompanyId;
    private String features;
    private BigDecimal price;
    private String categoryId;

    private Boolean active;
    //private String
}
