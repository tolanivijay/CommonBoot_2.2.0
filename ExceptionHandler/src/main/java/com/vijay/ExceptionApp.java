package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExceptionApp {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionApp.class, args);
		System.out.println("App Started");

	}
	
	@GetMapping("/")
	public String testMessage() {
		int i =1/0;
		return "Test Message";
	}

}
