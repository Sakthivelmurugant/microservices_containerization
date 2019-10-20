package com.handson.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration( ) {
	 System.out.println("--------------------------Config---------------------------");
	 System.out.println(configuration);
	 return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());	
	}

}
