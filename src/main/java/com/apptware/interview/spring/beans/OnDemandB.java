package com.apptware.interview.spring.beans;

import org.springframework.stereotype.Component;

@Component
class OnDemandB extends BaseOnDemand {

  OnDemandB(String someString) {
    super(someString);
  }

  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_B;
  }
}
