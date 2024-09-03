/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {

	private static Singleton single_instance = null;
	public String s;

	private Singleton() {
		if (single_instance != null) {
			throw new RuntimeException("Instance already created. Use getInstance() method.");
		}
		s = "Hello I am a string part of Singleton class";
	}
	public static synchronized Singleton getInstance() {
		if (single_instance == null) single_instance = new Singleton();
			return single_instance;
	}
}

//public enum Singleton {
//    INSTANCE;
//
//    public String s;
//
//    private Singleton() {
//        s = "Hello I am a string part of Singleton class";
//    }
//
//    public static Singleton getInstance() {
//        return INSTANCE;
//    }
//}

/**
 * Based on my understanding, reflection can be prevented in a Singleton class by throwing an exception in the private constructor if an instance already exists or by using an enum to implement the Singleton pattern. 
 * However, in the given test case, which uses reflection to create a new instance, both approaches will cause the test to fail because they prevent a second instance from being created. 
 * This means that without modifying the test case, it's not possible to pass the test while also fully protecting the Singleton against reflection
 */
