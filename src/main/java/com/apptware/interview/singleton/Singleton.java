package com.apptware.interview.singleton;

public class Singleton {

  // Making the instance field `volatile` ensures that changes to the instance are visible to all threads
  private static volatile Singleton instance = null;

  private String s;

  // Updated the constructor and includes a check to prevent instantiation via reflection
  private Singleton() {
    if (instance != null) {
      throw new RuntimeException("Use getInstance() method to create the Singleton instance");
    }
    s = "Hello I am a string part of Singleton class";
  }
  
  // Provides global access to Singleton instance
  // Apply double-checked locking mechanism
  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }

  // Prevents multiple instances during deserialization
  private Object readResolve() {
    return instance;
  }

  // Prevents cloning
  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}
