/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {
  private static final Singleton instance = new Singleton();
 
  private Singleton() {

  }

  public static Singleton getInstance() {
      return instance;
  }

  @Override
  public int hashCode() {

    return Integer.MAX_VALUE;
  }
}