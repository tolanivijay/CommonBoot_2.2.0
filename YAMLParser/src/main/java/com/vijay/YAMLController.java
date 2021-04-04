package com.vijay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YAMLController {

	@Autowired
	private YAMLConfigs configs;
	
	@GetMapping("/configs")
	public String getConfigs() {
		return configs.toString();
	}
	
}
