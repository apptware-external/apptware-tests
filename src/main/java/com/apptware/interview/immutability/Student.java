/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public final class Student {
  private final String name;
  private final Date dateOfBirth; // Change type to Date
  private final List<String> courses;

  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = new Date(dateOfBirth.getTime()); // Create a new Date object
    this.courses = Collections.unmodifiableList(courses);
  }

  public String getName() {
    return name;
  }

  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime()); // Return a new Date object
  }

  public List<String> getCourses() {
    return courses;
  }
}
