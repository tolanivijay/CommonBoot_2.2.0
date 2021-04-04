package com.vijay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestApp {

	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
		System.out.println("App Started");
	}
	
	@GetMapping("/hello")
	public String getMessage() {
		return "Hello from Test App";
	}

}
