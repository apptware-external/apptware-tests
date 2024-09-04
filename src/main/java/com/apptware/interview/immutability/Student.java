/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Student {
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;
  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  /**
   *  Returns a new ArrayList containing a copy of the courses list to make sure original list cannot be modified from outside the class.
   */
  public List<String> getCourses() {
    return new ArrayList<>(courses);
  }

  /**
   *  Ensure that the original list passed to the constructor is immutable.
   *  Also creating defensive copy of dateOfBirth
   */
  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = new Date(dateOfBirth.getTime());
    this.courses = List.copyOf(courses);
  }
}
