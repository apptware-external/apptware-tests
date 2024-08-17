package com.apptware.interview.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {
	private static final long serialVersionUID = 1L;

	private static Singleton single_instance = null;

	public String s;

	private Singleton() {
		   s = "Hello I am a string part of Singleton class";
	}

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

		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Singleton other = (Singleton) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

}

//  Here is the other approach
//package com.apptware.interview.singleton;
//
//import java.io.Serializable;
//
//public class Singleton {
//
//    // Static variable to hold the single instance of the class
//    private static Singleton singleInstance = null;
//    static int count = 0;
//
//    // Private constructor to prevent instantiation
//    private Singleton() {
//        // Check if the instance already exists
//        if (singleInstance != null) {
//
//            return;
//        }
//        // Assign the single instance
//        singleInstance = this;
//
//        count = numbergenerate();
//
//    }
//
//    // Public method to provide access to the single instance
//    public static synchronized Singleton getInstance() {
//        if (singleInstance == null) {
//            singleInstance = new Singleton();
//        }
//
//        return singleInstance;
//
//    }
//
//    // Ensure the same instance is returned during deserialization
//    protected Object readResolve() {
//        return getInstance();
//    }
//
//    @Override
//    public int hashCode() {
//        return count;
//
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//
//        if (obj.hashCode() == this.hashCode()) {
//
//            return true;
//        }
//        return false;
//    }
//
//    public static int numbergenerate() {
//        int randomIntInRange = (int) (Math.random() * 1000); // 0 to 99
//        return randomIntInRange;
//    }
//}