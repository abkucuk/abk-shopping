package com.MySbCommerce.abkshopping.product.model;

import com.MySbCommerce.abkshopping.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class ProductSaveRequest {
    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private BigDecimal price;
    private MoneyTypes moneyTypes;
    private List<String> images;
    private String sellerId;
    private String categoryId;

    /*
    *  {
          'image': 'https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg',
          'name': 'Awesome Product 1',
          'description': 'Product featured description',
          'seller': 'Awesome Company 1',
          'features': '<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>',
          'available': 2,
          'freeDelivery': true,
          'deliveryIn': 'In 3 days',
          'price':120,
          'money':'$'
        },
    * */

}
