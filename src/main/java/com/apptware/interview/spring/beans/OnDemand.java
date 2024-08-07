package com.apptware.interview.spring.beans;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class OnDemand {

  @Getter private final String someString;

  OnDemand(String someString) {
    this.someString = someString;
  }
}
