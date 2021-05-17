package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CallerServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(CallerServiceApp.class, args);
		System.out.println("CallerService Started");

	}
	@GetMapping("/caller")
	public String getString() {
		RestTemplate template = new RestTemplate();
		/*System.out.println("All properties is "+System.getProperties());
		System.out.println("All env is "+System.getenv());*/
		String ipCalled = System.getenv("IP_CALLED");
		if (StringUtils.isEmpty(ipCalled)){
			ipCalled ="localhost";
		}
		System.out.println("Called service is pointed to "+ipCalled);
		String url ="http://"+ipCalled +":9091/called";
		ResponseEntity<String> response =template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
		System.out.println("Response is "+response);
		
		return "Message by CalledService"+response.getBody();
	}

}
