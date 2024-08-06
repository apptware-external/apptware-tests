/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {
  private static volatile Singleton single_instance;

  public String s;

  private Singleton() {
    if (single_instance != null) {
      throw new IllegalStateException("Instance already created.");
    }
    single_instance = this;
    s = "Hello I am a string part of Singleton class";
  }

  public static Singleton getInstance() {
    if (single_instance == null) {
      synchronized (Singleton.class) {
        if (single_instance == null) {
          single_instance = new Singleton();
        }
      }
    }
    return single_instance;
  }

  // Ensure singleton property during deserialization
  protected Object readResolve() {
    return getInstance();
  }
}

