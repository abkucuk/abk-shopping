package com.MySbCommerce.abkshopping.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSellerResponse {
    private String Id;
    private String name;
}
