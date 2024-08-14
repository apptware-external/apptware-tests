/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Student {
  private final String name;
  private final Date dateOfBirth;
  private final List<String> courses;

  public Date getDateOfBirth() {
    return new Date(dateOfBirth.getTime());
  }

  public List<String> getCourses() {
    return new ArrayList<>(courses);
  }
}
