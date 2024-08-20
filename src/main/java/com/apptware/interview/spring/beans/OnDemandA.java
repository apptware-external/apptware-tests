package com.apptware.interview.spring.beans;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
class OnDemandA extends BaseOnDemand {

  public OnDemandA(@Value("#{someString}") String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_A;
  }

  @Override
  public String getSomeString() {
    return super.getSomeString();
  }
}