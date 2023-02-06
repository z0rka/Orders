package com.example.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class OrdersApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

}
