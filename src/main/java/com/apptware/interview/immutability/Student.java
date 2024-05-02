/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
//To make the class immutable, added final keyword
public final class Student {
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

  public String getName() {
    return name;
  }

  //Getter returns a copy of the Date object, so that the original value can't be changed
  //as for final variables, we can't assign new reference, but the value can be changed
  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  //Getter returns a copy of the List, so that the original List can't be changed
  //as for final variables, we can't assign new reference, but the value can be added in the list
  public List<String> getCourses() {
    return new ArrayList<>(courses);
  }
}
