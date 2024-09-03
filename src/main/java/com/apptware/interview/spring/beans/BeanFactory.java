package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

  @Autowired 
  private ApplicationContext context;

  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
	    switch (someEnum) {
	      case SOME_ENUM_A:
	        return context.getBean(OnDemandA.class, someString);
	      case SOME_ENUM_B:
	        return context.getBean(OnDemandB.class, someString);
	      default:
	        throw new IllegalArgumentException("Unknown SomeEnum value: " + someEnum);
	    }
	  }
  
  /**
   * Configuration Class: I created a OnDemandConfig class with factory methods annotated with @Bean and @Scope("prototype"). 
   * This allows Spring to create new instances of OnDemandA and OnDemandB with the required constructor arguments (someString).
   */
  
  /**
   * BeanFactory Class: I updated the BeanFactory class to fetch the correct prototype-scoped bean 
   * (OnDemandA or OnDemandB) based on the SomeEnum value and pass the someString argument.
   */
  
  /**
   * With this configuration, the correct OnDemand bean (OnDemandA or OnDemandB) is instantiated with the specified someString value, 
   * meeting the test case requirements and ensuring that the getSomeString() and getSomeEnum() methods return the expected results
   */
}
