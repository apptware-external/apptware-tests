package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

  @Autowired private ApplicationContext context;

  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
    if (someEnum.name().contains("A")) {
      return context.getBean(OnDemandA.class, someString);
    }
    return context.getBean(OnDemandB.class, someString);
  }
}
