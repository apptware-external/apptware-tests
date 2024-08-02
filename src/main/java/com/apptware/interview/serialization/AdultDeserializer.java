package com.apptware.interview.serialization;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;

public class AdultDeserializer extends JsonDeserializer<Adult> {

    @Override
    public Adult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String firstName = node.get("firstName").asText();
        String lastName = node.get("lastName").asText();
        Integer age = (node.get("age") != null) ? node.get("age").asInt() : null;
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
        }
        if (age == null || age < 18) {
            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
        }
        return new Adult(firstName, lastName, age);
    }
}
