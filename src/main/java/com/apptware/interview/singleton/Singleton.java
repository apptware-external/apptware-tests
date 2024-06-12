/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {

  // Private static variable to hold the single instance of the class
  private static Singleton instance;

  // Private constructor to prevent direct instantiation

  public String s;
  private Singleton() {

    s = "Hello I am a string part of Singleton class";
  }

  // Public static method to obtain the instance of the class
  public static Singleton getInstance() {
    // Lazily initialize the instance if it's not already initialized
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
