package com.MySbCommerce.abkshopping.product.services;

import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
    public String getProductMainImage(String productId){
        return "https://lallahoriye.com.tirzee.com/wp-content/uploads/2019/04/Product_Lg_Type.jpg";
    }
}
