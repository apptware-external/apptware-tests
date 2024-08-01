package com.apptware.interview.serialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//used Jackson annotations for JSON deserialization, with a custom deserializer and constructor-based deserialization

@Data
@NoArgsConstructor
@JsonDeserialize(using = AdultDeserializer.class)
public class Adult {

  private String firstName;
  private String lastName;
  private Integer age;

  //used JsonCreator annotation for used to create an Adult object from json data
  //used JsonProperty annotation for map json properties to the constructor parameters.
  @JsonCreator
  public Adult(@JsonProperty("firstName") String firstName,
               @JsonProperty("lastName") String lastName,
               @JsonProperty("age") Integer age) {
    if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
      throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
    }

    if (age == null || age < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
}
