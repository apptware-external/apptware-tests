/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {
  private static volatile Singleton single_instance = null;

  public String s;

  private Singleton() {
    if (single_instance != null) {
      throw new RuntimeException("Reflection is not allowed. Use getInstance() method to get the singleton instance.");
    }
    s = "Hello I am a string part of Singleton class";
  }

  public static synchronized Singleton getInstance() {
    if (single_instance == null) single_instance = new Singleton();

    return single_instance;
  }
}
