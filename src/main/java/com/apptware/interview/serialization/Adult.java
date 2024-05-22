package com.apptware.interview.serialization;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(using = AdultDeserializer.class)
@JsonSerialize
public class Adult {

  private String firstName;
  private String lastName;
  private Integer age;

  /**
   * This class has a constructor validation that restricts illegal Adult instances which doesn't
   * work during deserialization. Modify the code in this file so that we can also restrict illegal
   * Adult instances during deserialization.
   */
  public Adult(@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("age") Integer age) {
    if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
      throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
    }

    if (Objects.isNull(age) || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
}
