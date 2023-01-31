package com.example.orders.repository;

import com.example.orders.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * Repository for class {@link Product}
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String name);

    void deleteByName(String name);
}
