package com.MySbCommerce.abkshopping.product.domain.es;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyEs {
    private String Id;
    private String name;
    private String code;
}
