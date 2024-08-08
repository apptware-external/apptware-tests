package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

	@Autowired
	private ApplicationContext context;

	public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {
		String beanName;
		switch (someEnum) {
		case SOME_ENUM_A:
			beanName = "onDemandA";
			break;
		case SOME_ENUM_B:
			beanName = "onDemandB";
			break;
		default:
			throw new IllegalArgumentException("Unknown enum type: " + someEnum);
		}
		return (OnDemand) context.getBean(beanName, someString);
	}
}
