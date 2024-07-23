package com.apptware.interview.serialization;

import java.io.IOException;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Data
@NoArgsConstructor
@JsonDeserialize(using = AdultDeserializer.class)

public class Adult {

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("age")
  private Integer age;

  /**
   * This class has a constructor validation that restricts illegal Adult
   * instances which doesn't work during deserialization. Modify the code in this
   * file so that we can also restrict illegal Adult instances during
   * deserialization.
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

class AdultDeserializer extends JsonDeserializer<Adult> {

  @Override
  public Adult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
          throws JsonProcessingException, IOException {
    ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
    JsonNode node = mapper.readTree(jsonParser);

    String firstName = node.get("firstName").asText();
    String lastName = node.get("lastName").asText();
    Integer age = node.get("age").asInt();

    return new Adult(firstName, lastName, age);

  }
}
