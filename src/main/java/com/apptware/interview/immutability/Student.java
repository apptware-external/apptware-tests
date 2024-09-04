/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public record Student(String name, Date dateOfBirth, List<String> courses) {
  public Student(String name, Date dateOfBirth, List<String> courses) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.courses = courses;
    List<String> tempList = new ArrayList<>();
    courses.forEach(x -> tempList.add(x));
  }

  @Override
  public Date dateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  @Override
  public List<String> courses() {
    List<String> tempList = new ArrayList<>();
    courses.forEach(x -> tempList.add(x));
    return tempList;
  }
}
