package com.apptware.interview.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;

@Data
@NoArgsConstructor
//To inform ObjectMapper to use AdultDeserializer class to deserialize the Adult class objects
@JsonDeserialize(using = AdultDeserializer.class)
public class Adult {

  private String firstName;
  private String lastName;
  private Integer age;

  /**
   * This class has a constructor validation that restricts illegal Adult instances which doesn't
   * work during deserialization. Modify the code in this file so that we can also restrict illegal
   * Adult instances during deserialization.
   */
  public Adult(String firstName, String lastName, Integer age) {
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

/**
 * Here I have created a class extending JsonDeserializer, to override the existing
 * deserialize method and throw exceptions if firstName or lastName is blank or age is
 * below 18
 */
class AdultDeserializer extends JsonDeserializer<String> {

  @Override
  public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    ObjectNode node = p.readValueAsTree();
    boolean isFirstNameBlank = StringUtils.isBlank(node.get("firstName").asText());
    boolean isLastNameBlank = StringUtils.isBlank(node.get("lastName").asText());

    if(isFirstNameBlank || isLastNameBlank) {
        throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
    }

    if(node.get("age").asInt() < 18) {
      throw new IllegalArgumentException("Inappropriate Age for an Adult.");
    }
    return p.getValueAsString();
  }
}
