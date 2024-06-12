/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Student {
  private String name;
  private final Date dateOfBirth;
  private final List<String> courses;

// Constructor with defensive copies for mutable fields
//  public Student(String name, Date dateOfBirth, List<String> courses) {
//    this.name = name;
//    // Defensive copy for dateOfBirth
//    this.dateOfBirth = new Date(dateOfBirth.getTime());
//    // Defensive copy for courses list
//    this.courses = new ArrayList<>(courses);
//  }

  // Override getter for dateOfBirth to return a defensive copy
  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  // Override getter for courses to return an unmodifiable list
  public List<String> getCourses() {
    return new ArrayList<>(courses);  }
}
