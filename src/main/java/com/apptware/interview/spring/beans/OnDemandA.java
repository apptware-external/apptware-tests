package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class OnDemandA extends BaseOnDemand {

  OnDemandA(@Qualifier("someStringA") String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_A;
  }
}
