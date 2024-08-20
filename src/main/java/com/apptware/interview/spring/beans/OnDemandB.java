package com.apptware.interview.spring.beans;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
class OnDemandB extends BaseOnDemand {

  public OnDemandB(@Value("#{someString}") String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_B;
  }

  @Override
  public String getSomeString() {
    return super.getSomeString();
  }
}
