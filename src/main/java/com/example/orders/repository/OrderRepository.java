package com.example.orders.repository;

import com.example.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Kostiantyn Kvartyrmeister 30.01.2023
 * Repository for class {@link Order}
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query("update Order o set o.cost=?2 where o=?1")
    void update(Order order, float cost);

}
