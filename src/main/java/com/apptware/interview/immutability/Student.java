/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.Getter;

public class Student {
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

  // Constructor to initialize the fields
  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = new Date(dateOfBirth.getTime()); //Using Date(dateOfBirth.getTime()) so there will be no external modification;
    this.courses = Collections.unmodifiableList(courses); //Using Collections.unmodifiableList so courses cannot be modified once Student object created.
  }

  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());  // Use getTime() as in Test class it is testing for getTime()
  }

  public List<String> getCourses() {
    return new ArrayList<>(courses);
  }
}

//Since this is immutable class we cannot use setter ()
