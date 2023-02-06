package com.example.orders.service;

import com.example.orders.dto.OrderDto;
import com.example.orders.dto.OrderedProductDto;
import com.example.orders.dto.ProductDto;
import com.example.orders.model.Order;
import com.example.orders.model.OrderedProduct;
import com.example.orders.model.Product;
import com.example.orders.repository.OrderRepository;
import com.example.orders.repository.OrderedProductRepository;
import com.example.orders.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Service for {@link  Order}
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderedProductRepository orderedProductRepository;
    private final ObjectMapper objectMapper;

    /**
     * Method parses object {@link Order} to {@link OrderDto}
     *
     * @param order - {@link Order} from DB
     * @return {@link OrderDto} - parsed order
     */

    private OrderDto parseOrder(Order order) {
        OrderDto orderDto = objectMapper.convertValue(order, OrderDto.class);

        orderDto.setProductList(order.getProductList().stream().map(product -> {
            OrderedProductDto orderedProduct = objectMapper.convertValue(product, OrderedProductDto.class);
            orderedProduct.setProduct(objectMapper.convertValue(product.getProduct(), ProductDto.class));

            return orderedProduct;
        }).toList());

        return orderDto;
    }

    /**
     * Method builds object {@link OrderedProduct} and saves that to the DB
     *
     * @param order   - {@link Order} from DB
     * @param product - {@link Product} from DB
     */
    private void buildAndSaveOrderedProduct(Optional<Order> order, Optional<Product> product) {

        OrderedProduct orderedProduct = new OrderedProduct();
        orderedProduct.setOrder(order
                .orElseThrow(() -> new EntityNotFoundException("Order  not found")));

        orderedProduct.setProduct(product
                .orElseThrow(() -> new EntityNotFoundException("Product not found")));

        orderedProductRepository.save(orderedProduct);

        float cost = order.get().getCost() + product.get().getCost();

        orderRepository.update(order.get(), cost);
    }

    /**
     * Method to add new {@link Order}
     */
    public void placeOrder() {
        Order order = new Order();
        order.setCreationDate(LocalDate.now());
        order.setCost(0.0f);

        orderRepository.save(order);
    }

    /**
     * Method to add new product by name to the order
     *
     * @param orderId     - id of the {@link Order}
     * @param productName - name of the  {@link Product}
     */
    @Transactional
    public void addProduct(int orderId, String productName) {
        if (productName == null) {
            log.error("Product name is null");
            return;
        }

        Optional<Order> order = orderRepository.findById(orderId);
        Optional<Product> product = productRepository.findFirstByName(productName);

        buildAndSaveOrderedProduct(order, product);
    }

    /**
     * Method to add new product by id to the order
     *
     * @param orderId   - id of the {@link Order}
     * @param productId - id of the  {@link Product}
     */
    @Transactional
    public void addProduct(int orderId, int productId) {
        Optional<Order> order = orderRepository.findById(orderId);
        Optional<Product> product = productRepository.findById(productId);

        buildAndSaveOrderedProduct(order, product);
    }

    /**
     * Method to get order by id
     *
     * @param orderId - id of the {@link Order}
     * @return {@link OrderDto}
     */
    @Transactional
    public OrderDto getById(int orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return parseOrder(order.orElseThrow(() -> new EntityNotFoundException("Order  not found")));
    }

    /**
     * Method to get all orders
     *
     * @return {@link OrderDto} list
     */
    @Transactional
    public List<OrderDto> getAll() {
        List<Order> allOrders = orderRepository.findAll();

        return allOrders.stream().map(this::parseOrder).toList();
    }

    /**
     * Method to delete order
     *
     * @param orderId - id of the {@link Order}
     */
    @Transactional
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
