package com.example.orders.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * class to convert {@link com.example.orders.model.OrderedProduct}
 */

@Data
@NoArgsConstructor
public class OrderedProductDto {
    private Integer id;
    private ProductDto product;
    private OrderDto order;
}
