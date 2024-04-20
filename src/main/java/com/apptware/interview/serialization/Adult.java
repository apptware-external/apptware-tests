package com.apptware.interview.serialization;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.JsonParser;

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
  public static class AdultDeserializer extends StdDeserializer<Adult> {

    public AdultDeserializer() {
      super(Adult.class);
    }

    @Override
    public Adult deserialize(JsonParser parser, DeserializationContext context) throws IOException {
      JsonNode node = parser.getCodec().readTree(parser);
      String firstName = node.get("firstName").asText();
      String lastName = node.get("lastName").asText();
      int age = node.get("age").asInt();

      if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
        throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
      }

      if (age < 18) {
        throw new IllegalArgumentException("Inappropriate Age for an Adult.");
      }

      return new Adult(firstName, lastName, age);
    }
  }

}
