package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class OnDemandFactory {
	
	OnDemand demand = null;
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public OnDemand createOnDemandBean(String value) {
	
		if ("Hello World!!!".equalsIgnoreCase(value)) {
			demand = new OnDemandA(value);
			return demand;
		} else if ("Hello Other World!!!".equalsIgnoreCase(value)) {
			demand = new OnDemandB(value);
			return demand;
		}
		System.out.println(demand);
		return null;
	}
}
