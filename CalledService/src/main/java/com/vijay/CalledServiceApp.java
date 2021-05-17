package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CalledServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(CalledServiceApp.class, args);
		System.out.println("CalledServiceApp is up");
	}

	@GetMapping("/called")
	public String getString() {
		return "Message from CalledServiceApp";
	}
}
