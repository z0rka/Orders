package com.example.orders.configuration;

import com.example.orders.servlet.CustomServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author z0rka 30.01.2023
 * Servlet configuration
 */
@Configuration
public class ServletConfig {

    /**
     * Registration of servlet on localhost:8080
     *
     * @return {@link ServletRegistrationBean<>}
     */
    @Bean
    public ServletRegistrationBean customServletBean() {
        return new ServletRegistrationBean(new CustomServlet(), "");
    }

}
