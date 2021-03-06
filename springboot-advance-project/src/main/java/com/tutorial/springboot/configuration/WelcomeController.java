package com.tutorial.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	private BasicValueConfiguration configuration;
	
	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/welcome")
	public String welcome(){
		return message;
	}
	
	@GetMapping("/dynamic-configuration")
    public BasicValueConfiguration dynamicConfiguration() {        
        return configuration;
    }
}
