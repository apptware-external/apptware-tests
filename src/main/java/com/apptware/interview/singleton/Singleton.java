/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {
  private static Singleton single_instance = new Singleton();
  private static boolean createdViaReflection = false;

  public String s;

  private Singleton() {
    if (single_instance != null) {

    }
    s = "Hello I am a string part of Singleton class";
  }

  public static Singleton getInstance() {
    if (single_instance == null) {
      single_instance = new Singleton();
    }

    return single_instance;
  }

  public static Singleton getInstanceThroughReflection() {
    return single_instance;
  }
}
