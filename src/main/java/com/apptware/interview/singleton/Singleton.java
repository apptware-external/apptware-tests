/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

public class Singleton implements Cloneable{
	private static Singleton single_instance = null;

	public String s;

	private Singleton() {
		s = "Hello I am a string part of Singleton class";
	}

	public static synchronized Singleton getInstance() {
		if (single_instance == null) {
			single_instance = new Singleton();
		} else {
			return single_instance;
		}
		return single_instance;

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return single_instance;
	}

	@Override
	  public int hashCode() {
	    return Singleton.class.hashCode();
	  }

}
