package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

// Do not change this class
abstract class BaseOnDemand implements OnDemand {

  @Autowired
  private SomeComponent someComponent;

  private final String someString;

  BaseOnDemand(String someString) {
    this.someString = someString;
  }

  @Override
  public String getSomeString() {
    return someComponent.processSomeString(someString);
  }
}
