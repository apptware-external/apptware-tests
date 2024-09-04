/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {
  private static volatile Singleton single_instance = null;
  private static int hashCode;

  public String s;

  private Singleton() {
    s = "Hello I am a string part of Singleton class";
    if (single_instance != null) {
      single_instance = this;
    } else {
      single_instance = this;
      hashCode = super.hashCode();
    }
  }


  @Override
  public int hashCode() {
    return hashCode;
  }

  public static synchronized Singleton getInstance() {
    if (single_instance == null) single_instance = new Singleton();

    return single_instance;
  }
}
