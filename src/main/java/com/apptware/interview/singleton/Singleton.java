/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;



public class Singleton  {
	  private static Singleton single_instance = new Singleton() ;

	  public String s;

	  // Throwing an exception is not expected.
	  private Singleton() {
	    s = "Hello I am a string part of Singleton class";
	  }

	  public static Singleton getInstance() {
	    if (single_instance == null) {
	    	synchronized (Singleton.class) {
				if(single_instance == null)
					single_instance = new Singleton();
			}
	    }
	    return single_instance;
	  }  
	  
	  @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return System.identityHashCode(this.single_instance);
	}
	  
	}
