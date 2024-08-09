/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Student {
  private String name;
  private Date dateOfBirth;
  private List<String> courses;

  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = new Date(dateOfBirth.getTime());
    this.courses = new ArrayList<>(courses);
  }

  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  public List<String> getCourses() {
    return new ArrayList<>(courses);
  }
}
