package com.example.orders.controllers;

import com.example.orders.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author z0rka 06.02.2023;
 * Controller of the store
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class StoreController {

    private final StoreService storeService;

    /**
     * Method to add product to the store
     *
     * @param productName - product name
     * @param price       - product price
     */
    @PostMapping("")
    public String addProduct(@RequestParam String productName, @RequestParam float price) {
        log.info("Add product to store method invoked");

        storeService.addProduct(productName, price);

        log.info("Add product to store method ended");
        return "Product to the store successfully added";
    }

    /**
     * Method to delete product from the store by name
     *
     * @param productName - product name
     */
    @DeleteMapping("")
    public String deleteProduct(@RequestParam String productName) {
        log.info("Delete product from store by name method invoked");

        storeService.deleteProduct(productName);

        log.info("Delete product from store by name method ended");
        return "Product  successfully deleted ";
    }

    /**
     * Method to delete product from the store by id
     *
     * @param id - product id
     */
    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id) {
        log.info("Delete product from store by id method invoked");

        storeService.deleteProduct(id);

        log.info("Delete product from store by id method ended");
        return "Product  successfully deleted ";
    }
}
