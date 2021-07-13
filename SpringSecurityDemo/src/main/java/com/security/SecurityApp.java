package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages="com.security")
@RestController
public class SecurityApp {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp.class, args);

	}
	
	@GetMapping("/open")
	public String open() {
		return "Everyone can call";
	}

	@GetMapping("/users")
	public String users() {
		return "Only Users allowed";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Only Admin allowed";
	}
}
