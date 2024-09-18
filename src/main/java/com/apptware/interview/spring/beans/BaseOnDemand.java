package com.apptware.interview.spring.beans;

import lombok.Getter;

// Do not change this class
abstract class BaseOnDemand implements OnDemand {

  @Getter private final String someString;

  BaseOnDemand(String someString) {
    this.someString = someString;
  }
}
