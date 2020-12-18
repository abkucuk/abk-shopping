package com.MySbCommerce.abkshopping.product.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public enum MoneyTypes {
    USD("Dollar","$"),
    EUR( "Euro", "E"),
    TL( "Türk Lirası",  "TL");
    private String label; // Dollar
    private String symbol; // $
    MoneyTypes(String label, String symbol){
        this.label = label;
        this.symbol = symbol;
    }

}

