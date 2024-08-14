package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("OnDemandB")
class OnDemandB extends BaseOnDemand {

  OnDemandB(@Value("defaultValue") String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_B;
  }
}
