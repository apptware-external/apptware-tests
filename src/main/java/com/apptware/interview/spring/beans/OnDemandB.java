package com.apptware.interview.spring.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * <p>
 * The {@code @Lazy} annotation ensures that this bean is not instantiated until it is needed.
 * the bean is created when it is actually required.
 *
 * We could have also solved using @Scope("prototype")
 */
@Component
@Lazy
class OnDemandB extends BaseOnDemand {

  OnDemandB(String someString) {
    super(someString);
  }

  @Override
  public SomeEnum getSomeEnum() {
    return SomeEnum.SOME_ENUM_B;
  }
}
