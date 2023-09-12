package com.example.usertask.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Log information about incoming requests
        logger.info("Request Intercepted - Method: {}, URI: {}", request.getMethod(), request.getRequestURI());
        return true; // Continue with the request handling
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Log information about successful request processing
        logger.info("Request Processed Successfully - Status: {}, URI: {}", response.getStatus(), request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Log information about request completion, including errors (if any)
        if (ex != null) {
            logger.error("Request Completed with Error - Status: {}, URI: {}, Error Message: {}", response.getStatus(), request.getRequestURI(), ex.getMessage());
        } else {
            logger.info("Request Completed - Status: {}, URI: {}", response.getStatus(), request.getRequestURI());
        }
    }
}
