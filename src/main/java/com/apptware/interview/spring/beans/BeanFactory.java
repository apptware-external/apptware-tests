
package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

//  @Autowired private ApplicationContext context;
//
//  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
//	  System.out.println(someString);
//    return context.getBean(BaseOnDemand.class, someString);
//  }
	
	private final ApplicationContext context;

	  @Autowired
	  public BeanFactory(ApplicationContext context) {
	    this.context = context;
	  }

	  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
	    switch (someEnum) {
	      case SOME_ENUM_A:
	        return new OnDemandA(someString);
	      case SOME_ENUM_B:
	        return new OnDemandB(someString);
	      default:
	        throw new IllegalArgumentException("Unknown enum type: " + someEnum);
	    }
	  }
}
