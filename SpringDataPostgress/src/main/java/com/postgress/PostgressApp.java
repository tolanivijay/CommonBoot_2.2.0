package com.postgress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.postgress")
@RestController
public class PostgressApp {

	public static void main(String[] args) {
		SpringApplication.run(PostgressApp.class, args);
		System.out.println("App started");
	}

	


}
