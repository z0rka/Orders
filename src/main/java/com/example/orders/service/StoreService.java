package com.example.orders.service;

import com.example.orders.model.Product;
import com.example.orders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service for store to add {@link Product} to the DB
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {
    private final ProductRepository productRepository;

    /**
     * Method to save new {@link Product} to DB
     *
     * @param name - name of the {@link Product}
     * @param cost - cost of the {@link Product}
     */
    public void addProduct(String name, float cost) {
        if (name == null) {
            log.error("Name is null");
            return;
        }

        Product product = new Product();
        product.setName(name);
        product.setCost(cost);

        productRepository.save(product);
    }

    /**
     * Method to delete {@link Product} from DB by id
     *
     * @param productId - id of the {@link Product}
     */
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    /**
     * Method to delete {@link Product} from DB by name
     *
     * @param name - name of the {@link Product}
     */
    public void deleteProduct(String name) {
        if (name == null) {
            log.error("Name is null");
            return;
        }

        productRepository.deleteByName(name);
    }
}
