package com.apptware.interview.spring.beans;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class OnDemandB extends BaseOnDemand {

  OnDemandB(String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_B;
  }
}
