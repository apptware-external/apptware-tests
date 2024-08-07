package com.apptware.interview.serialization;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
public class Adult {
  private String firstName;
  private String lastName;
  private Integer age;

  @JsonCreator
  public Adult(@JsonProperty("firstName") String firstName,
               @JsonProperty("lastName") String lastName,
               @JsonProperty("age") Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    validate();
  }

  private void validate() {
    if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
      throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
    }

    if (Objects.isNull(age) || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }
  }

  // getters and setters
}