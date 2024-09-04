package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

  @Autowired private ApplicationContext context;
  /**
   * BeanFactory Class: The BeanFactory class has been updated to properly retrieve beans.
   * It now uses a switch statement to fetch the appropriate bean (OnDemandA or OnDemandB) based on the SomeEnum value,
   * and passes the someString argument to the bean's constructor.
   */

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
}
