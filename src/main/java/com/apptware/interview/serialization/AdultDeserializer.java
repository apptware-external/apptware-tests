package com.apptware.interview.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

class AdultDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectNode node = p.readValueAsTree();
        boolean isFirstNameBlank = StringUtils.isBlank(node.get("firstName").asText());
        boolean isLastNameBlank = StringUtils.isBlank(node.get("lastName").asText());

        if (isFirstNameBlank || isLastNameBlank) {
            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
        }

        if (node.get("age").asInt() < 18) {
            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
        }
        return p.getValueAsString();
    }
}