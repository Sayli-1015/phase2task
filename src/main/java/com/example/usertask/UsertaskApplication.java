package com.example.usertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.example.usertask")
public class UsertaskApplication {
    public static void main(String[] args) {
        System.out.println("hello started");
        SpringApplication.run(UsertaskApplication.class, args);
    }
}
