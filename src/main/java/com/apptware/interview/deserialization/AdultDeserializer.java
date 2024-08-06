package com.apptware.interview.deserialization;

import java.io.IOException;

import com.apptware.interview.serialization.Adult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/*
  - Added AdultDeserializer for deserialization
  -  This custom deserializer ensures that validation logic is applied during deserialization.
  -  This enables to include validation logic that runs when the Adult object is created from JSON.
  -  When JSON is deserialized into an Adult object, the deserializer checks
        for validation errors and throws IllegalArgumentException with appropriate messages.
 */

public class AdultDeserializer extends JsonDeserializer<Adult> {

    @Override
    public Adult deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        try{
            JsonNode node = p.getCodec().readTree(p);
            String firstName = node.get("firstName").asText();
            String lastName = node.get("lastName").asText();
            Integer age = node.get("age").asInt();

            // Validation logic
            if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
                throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
            }
            if (age == null || age < 18) {
                throw new IllegalArgumentException("Inappropriate Age for an Adult.");
            }

            return new Adult(firstName, lastName, age);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Invalid JSON format for Adult object.");   
        }
    }
}