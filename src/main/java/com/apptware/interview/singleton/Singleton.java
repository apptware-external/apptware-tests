/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {
  private static volatile Singleton instance;
  private static boolean instanceCreated = false;

  private Singleton() {
    if (instanceCreated) {
      throw new IllegalStateException("Singleton instance already created.");
    }
    instanceCreated = true;
  }

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
}
