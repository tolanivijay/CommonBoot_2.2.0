package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YAMLApp {
	
	/*@Autowired
	private static YAMlWriter writer;*/

	public static void main(String[] args) {
		SpringApplication.run(YAMLApp.class, args);
		System.out.println("App Started");
		
		//writer.writeToDisk();
	}

}
