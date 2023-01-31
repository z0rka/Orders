package com.example.orders.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * class for table ordered_product
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "my_shop")
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_product_id",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_order_id", nullable = false)
    private Order order;
}
