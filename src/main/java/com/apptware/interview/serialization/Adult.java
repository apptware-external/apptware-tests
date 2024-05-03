package com.apptware.interview.serialization;

import java.util.Objects;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class Adult {

  private String firstName;
  private String lastName;
  private Integer age;
 
  /**
   * This class has a constructor validation that restricts illegal Adult instances which doesn't
   * work during deserialization. Modify the code in this file so that we can also restrict illegal
   * Adult instances during deserialization.
   */

  public Adult() {}

  public Adult(String firstName, String lastName, Integer age) {
    setFirstName(firstName);
    setLastName(lastName);
    setAge(age);
  }

  public void setFirstName(String firstName) {
    if (StringUtils.isBlank(firstName)) {
      throw new IllegalArgumentException("Firstname CANNOT be blank.");
    }
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    if (StringUtils.isBlank(lastName)) {
      throw new IllegalArgumentException("Lastname CANNOT be blank.");
    }
    this.lastName = lastName;
  }

  public void setAge(Integer age) {
    if (Objects.isNull(age) || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }
    this.age = age;
  }

  private void validate() {
    if (StringUtils.isBlank(firstName)) {
      throw new IllegalArgumentException("Firstname CANNOT be blank.");
    }
    if (StringUtils.isBlank(lastName)) {
      throw new IllegalArgumentException("Lastname CANNOT be blank.");
    }
    if (Objects.isNull(age) || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }
  }

  private Object readResolve() {
    validate();
    return this;
  }
}