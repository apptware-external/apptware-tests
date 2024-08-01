package com.apptware.interview.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;

//steps
//1.used json data using JsonParse & convert it to JsonNode
//2.extarct fields from JsonNode
//3.validate the extracted data (firstName, lastName are not blank & age is appropriate)
//4.return an Adult object if successful

public class AdultDeserializer extends JsonDeserializer<Adult> {
    @Override
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
