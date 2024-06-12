package com.apptware.interview.serialization;

import java.io.Serializable;
import java.util.Objects;

import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.StringUtils;


@Getter
@Setter
@NoArgsConstructor
public class Adult implements Serializable {
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private Integer age;

  /**
   * This class has a constructor validation that restricts illegal Adult instances which doesn't
   * work during deserialization. Modify the code in this file so that we can also restrict illegal
   * Adult instances during deserialization.
   */
/*  public Adult(String firstName, String lastName, Integer age) {
    if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
      throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
    }

    if (Objects.isNull(age) || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }*/

  @JsonCreator
  public Adult(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("age") Integer age) throws IllegalArgumentException{
    // Remove validation logic from constructor and move it to a separate method
    System.out.println("jkbjsdgfgdsfm");
    validate(firstName, lastName, age);
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  // Validation method to check if the provided data is valid for an Adult instance
  private void validate(String firstName, String lastName, Integer age) {
    System.out.println("IDHR AA GYA");

    if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
      System.out.println("IDHR AA GYA+1111");
      throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
    }

    if (Objects.isNull(age) || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }
  }





}
