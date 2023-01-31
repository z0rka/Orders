package com.example.orders.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * class to convert {@link com.example.orders.model.Product}
 */
@Data
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private float cost;
    private List<OrderedProductDto> orderedProduct;
}
