package com.example.orders.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * class to convert {@link com.example.orders.model.Order}
 */

@Data
@NoArgsConstructor
public class OrderDto {

    private Integer id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate creationDate;

    private float cost;

    private List<OrderedProductDto> productList;
}
