/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
  private String name;
  private Date dateOfBirth;
  private List<String> courses;

      // Methods to access fields

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime()); // Defensive copying to prevent mutation
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses); // Making courses unmodifiable
    }
}
