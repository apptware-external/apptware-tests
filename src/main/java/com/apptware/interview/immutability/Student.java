/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = new Date(dateOfBirth.getTime()); // Defensive copy
    this.courses = new ArrayList<>(courses); // Defensive copy
  }

  public String getName() {
    return name;
  }

  public Date getDateOfBirth() {
    // Return a defensive copy to prevent modification of the original date
    return new Date(dateOfBirth.getTime());
  }

  public List<String> getCourses() {
    // Return a defensive copy to prevent modification of the original list
    return new ArrayList<>(courses);
  }
}
