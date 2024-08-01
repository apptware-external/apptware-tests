/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton {

  //volatile - changes to instance visible to all threads
  private static volatile Singleton instance = null;

  public String s;


  private Singleton() {
    s = "Hello I am a string part of Singleton class";
  }

  //provides global access to singletone instance
  //apply double-checked locking mechanism
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

  //used during deserialization (it returns the existing instance instead of creating a new one.)
  private Object readResolve() {
    return getInstance();
  }

  //for prevent cloning of singletonr instance
  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Cannot clone a Singleton");
  }
  //based on instance identity, returns hash code of singletone instance
  @Override
  public int hashCode() {
    return System.identityHashCode(instance);
  }
}
