package com.apptware.interview.serialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

@Data
@NoArgsConstructor
public class Adult {

  private String firstName;
  private String lastName;
  private Integer age;

  /**
   * This class has a constructor validation that restricts illegal Adult instances which doesn't
   * work during deserialization. Modify the code in this file so that we can also restrict illegal
   * Adult instances during deserialization.
   */
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
  public String getFirstname() {
    return firstName;
  }

  public String getLastname() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  // Custom deserializer for Adult class
  public static abstract class AdultDeserializer extends StdDeserializer<Adult> {
    public AdultDeserializer() {
      this(null);
    }


    protected AdultDeserializer(Class<?> vc) {
      super(vc);
    }


    public Adult deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
      JsonNode node = jp.getCodec().readTree(jp);
      String firstName = node.get("firstName").asText();
      String lastName = node.get("lastName").asText();
      Integer age = node.get("age").asInt();

      // Perform validation
      if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
        throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
      }

      if (age == null || age < 18) {
        throw new IllegalArgumentException("Inappropriate Age for an Adult.");
      }

      return new Adult(firstName, lastName, age);
    }
  }
}
