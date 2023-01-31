package com.example.orders.configuration;

import com.example.orders.servlet.DispatcherServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author z0rka 30.01.2023
 */
@Configuration
public class ConfigurationInitializer {

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean<>(new DispatcherServlet(), "");
        servletBean.setLoadOnStartup(1);
        return servletBean;
    }
}
