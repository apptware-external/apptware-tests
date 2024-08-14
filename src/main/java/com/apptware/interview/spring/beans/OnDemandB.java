package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class OnDemandB extends BaseOnDemand {

  OnDemandB(@Qualifier("someStringB") String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_B;
  }
}
