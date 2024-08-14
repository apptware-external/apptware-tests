/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {
  private static volatile Singleton single_instance = null;

  public final String s = "Hello I am a string part of Singleton class";

  private Singleton() {}

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

  @Override
  public int hashCode() {
    return s.hashCode();
  }
}
