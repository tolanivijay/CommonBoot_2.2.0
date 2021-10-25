package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitMainApp {

    public static void main(String[] args) {
        SpringApplication.run(JunitMainApp.class, args);
        System.out.println("JunitMainApp Started");
    }
}
