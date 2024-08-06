/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;

//declared as final for preventing subclassing
public final class Student {

  //fields are declared AND assign only once and thus cannot be changed after construction
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

  //defensive copy is a programming technique used to protect the internal state of an object by creating
  // and working with copies of that state rather than exposing the original object directly.
  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = new Date(dateOfBirth.getTime()); // Create a defensive copy
    this.courses = List.copyOf(courses); // Create a defensive copy
  }

  //Getters are used to access the fields
  public String getName() {
    return name;
  }

  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime()); // Return a defensive copy
  }

  public List<String> getCourses() {
    return List.copyOf(courses); // Return an unmodifiable view
  }
}