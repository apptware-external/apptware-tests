/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {
  private static Singleton single_instance = new Singleton();

  public String s;

  private Singleton() {
    s = "Hello I am a string part of Singleton class";
  }

  public static synchronized Singleton getInstance() {
    if (single_instance == null) single_instance = new Singleton();

    return single_instance;
  }

  // Override hashCode method
  @Override
  public int hashCode() {
    return Singleton.class.hashCode();
  }
}
