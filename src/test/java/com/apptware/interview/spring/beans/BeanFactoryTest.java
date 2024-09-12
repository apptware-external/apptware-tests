package com.apptware.interview.spring.beans;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


// Do not change this class. The run will fail due to an error in the bean creation process that
// you're supposed to solve.
@SpringBootTest
class BeanFactoryTest {

  @Autowired private BeanFactory beanFactory;

  @Test
  void getOnDemandBean() {
    String someString = "Hello World!!!";
    SomeEnum someEnumA = SomeEnum.SOME_ENUM_A;
    OnDemand onDemandBeanA = beanFactory.getOnDemandBean(someEnumA, someString);
    Assertions.assertThat(onDemandBeanA.getSomeString()).isEqualTo(someString);
    Assertions.assertThat(onDemandBeanA.getSomeEnum()).isEqualTo(someEnumA);

    String someOtherString = "Hello Other World!!!";
    SomeEnum someEnumB = SomeEnum.SOME_ENUM_B;
    OnDemand onDemandBeanB = beanFactory.getOnDemandBean(someEnumB, someOtherString);
    Assertions.assertThat(onDemandBeanB.getSomeString()).isEqualTo(someOtherString);
    Assertions.assertThat(onDemandBeanB.getSomeEnum()).isEqualTo(someEnumB);
  }
}
