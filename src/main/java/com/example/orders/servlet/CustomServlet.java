package com.example.orders.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author z0rka 06.02.2023
 * Custom servlet
 */
@Slf4j
public class CustomServlet extends HttpServlet {
    /**
     * Rest method GET , could be found on localhost:8080
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("CustomServlet method doGet() started");
        resp.getWriter().println("Hello from " + this.getClass());
        resp.getWriter().close();
    }
}
