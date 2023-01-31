package com.example.orders.repository;

import com.example.orders.model.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * Repository for class {@link OrderedProduct}
 */
@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {
}
