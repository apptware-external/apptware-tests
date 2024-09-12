package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Do not change this class
@Component
abstract class BaseOnDemand implements OnDemand {

  @Autowired private SomeComponent someComponent;

  private final String someString;

  BaseOnDemand(String someString) {
    this.someString = someString;
  }

  @Override
  public String getSomeString() {
    return getSomeComponent().processSomeString(someString);
  }

public SomeComponent getSomeComponent() {
	return someComponent;
}

public void setSomeComponent(SomeComponent someComponent) {
	this.someComponent = someComponent;
}
}
