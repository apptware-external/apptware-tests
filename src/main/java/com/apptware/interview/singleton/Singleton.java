
package com.apptware.interview.singleton;

import java.io.Serializable;

/**
 * Singleton class ensures only one instance is created.
 */
public class Singleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Singleton SINGLE_INSTANCE;

    private String s;

    // Static block to initialize the singleton instance
    static {
        SINGLE_INSTANCE = new Singleton();
    }

    // Private constructor to prevent instantiation
    private Singleton Singleton() {
        if (SINGLE_INSTANCE != null) {
            
           System.out.println("Exiting one");
        }
       return  SINGLE_INSTANCE;
        
        //s = "Hello I am a string part of Singleton class";
    }

    
    public static Singleton getInstance() {
        return SINGLE_INSTANCE;
    }

    
}
