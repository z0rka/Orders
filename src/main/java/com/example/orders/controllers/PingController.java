package com.example.orders.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author z0rka 06.02.2023;
 * Controller to check if server is available
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ping")
public class PingController {
    /**
     * Method that returns OK if server is up
     */
    @GetMapping
    public String checkServerStatus() {
        log.info("Check server method invoked in class ");
        return "OK";
    }
}
