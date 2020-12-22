package com.MySbCommerce.abkshopping.product.domain.es;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class CategoryEs {
    private String Id;
    private String name;
    private String code;
}
