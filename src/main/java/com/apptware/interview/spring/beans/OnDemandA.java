package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("OnDemandA")
class OnDemandA extends BaseOnDemand {


  OnDemandA(@Value("defaultValue") String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_A;
  }
}