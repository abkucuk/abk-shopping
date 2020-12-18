package com.MySbCommerce.abkshopping.product.domain;

import lombok.Data;

@Data
public class ProductImage {
    private ImageType imageType;
    private String url;

    enum ImageType{
        FEATURE, NORMAL;
    }
}
