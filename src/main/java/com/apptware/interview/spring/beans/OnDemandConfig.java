package com.apptware.interview.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class OnDemandConfig {
	  @Bean
	  @Scope("prototype")
	  public OnDemandA onDemandA(String someString) {
	    return new OnDemandA(someString);
	  }

	  @Bean
	  @Scope("prototype")
	  public OnDemandB onDemandB(String someString) {
	    return new OnDemandB(someString);
	  }
	

}
