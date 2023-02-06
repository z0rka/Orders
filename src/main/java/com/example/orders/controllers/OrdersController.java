package com.example.orders.controllers;

import com.example.orders.dto.OrderDto;
import com.example.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author z0rka 06.02.2023;
 * Contoller of the orders
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    /**
     * Showing order with exact id
     *
     * @param id - id of the order
     * @return {@link OrderDto}
     */
    @GetMapping("{id}")
    public OrderDto getOrder(@PathVariable int id) {
        log.info("Get order by id method invoked");
        return orderService.getById(id);
    }

    /**
     * Showing all orders
     *
     * @return List {@link OrderDto}
     */
    @GetMapping("")
    public List<OrderDto> getOrders() {
        log.info("Get all orders method invoked");
        return orderService.getAll();
    }

    /**
     * Adding product to the order
     *
     * @param id          - id of the order
     * @param productName - name of the product
     */
    @PostMapping("{id}")
    public String addProductToOrder(@PathVariable int id, @RequestParam String productName) {
        log.info("Add product to order method invoked");

        orderService.addProduct(id, productName);

        log.info("Add product to order method ended");
        return "Product to the order order successfully added";
    }

    /**
     * Adding just empty order
     */
    @PostMapping("")
    public String addNewOrder() {
        log.info("Add order method invoked");

        orderService.placeOrder();

        log.info("Add order method ended");
        return "New order successfully placed";
    }
}
