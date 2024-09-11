package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

  @Autowired private ApplicationContext context;

  @Autowired
  public BeanFactory(ApplicationContext context) {
    this.context = context;
  }

  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
    if (someEnum == SomeEnum.SOME_ENUM_A) {
      return (OnDemand) context.getBean(OnDemandA.class, someString);
    } else if (someEnum == SomeEnum.SOME_ENUM_B) {
      return (OnDemand) context.getBean(OnDemandB.class, someString);
    }
    throw new IllegalArgumentException("Unknown enum type: " + someEnum);
  }
}
