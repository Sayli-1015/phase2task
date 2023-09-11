package com.example.usertask.Interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // This method is called before the request is handled by the controller.
        System.out.println("Request Intercepted: " + request.getRequestURI());
        // You can add your custom pre-processing logic here.
        return true; // Continue with the request handling
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // This method is called after the request is handled by the controller but before the view is rendered.
        System.out.println("Request Processed Successfully");
        // You can add your custom post-processing logic here.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // This method is called after the view is rendered and the response is sent to the client.
        System.out.println("Request Completed");
        // You can add your custom cleanup or finalization logic here.
    }
}
