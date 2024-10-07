/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Getter
@AllArgsConstructor
public final class Student {
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

//while returing create a new Date object to achive deep copy.
  public Date getDateOfBirth() {
    return new Date(this.dateOfBirth.getTime());
  }

  // Custom Getter for courses to return an unmodifiable list
  public List<String> getCourses() {
    return Collections.unmodifiableList(new ArrayList<>(this.courses));
  }
}