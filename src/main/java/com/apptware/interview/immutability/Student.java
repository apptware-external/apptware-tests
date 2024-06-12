/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;


public class Student {
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.courses = courses;
  }

  public String getName() {
    return name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public List<String> getCourses() {
    return courses;
  }
}
