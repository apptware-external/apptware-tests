package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;


@Component
public class BeanFactory {

  @Autowired private ApplicationContext context;

  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
    OnDemand onDemandBean;

    switch (someEnum) {
      case SOME_ENUM_A:
        onDemandBean = context.getBean(OnDemandA.class);
        break;
      case SOME_ENUM_B:
        onDemandBean = context.getBean(OnDemandB.class);
        break;
      default:
        throw new IllegalArgumentException("Unknown enum type: " + someEnum);
    }
    if (onDemandBean instanceof BaseOnDemand) {
      ((BaseOnDemand) onDemandBean).setSomeString(someString);
    }
    return onDemandBean;
   // return context.getBean(BaseOnDemand.class, someString);
  }
}
