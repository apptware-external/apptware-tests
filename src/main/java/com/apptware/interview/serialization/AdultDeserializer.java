package com.apptware.interview.serialization;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class AdultDeserializer extends StdDeserializer<Adult> {

	private static final long serialVersionUID = 3694742465181047552L;

	public AdultDeserializer() {
        this(null);
    }

    public AdultDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Adult deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String firstName = node.get("firstName").asText();
        String lastName = node.get("lastName").asText();
        Integer age = node.get("age").asInt();

        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
        }

        if (age == null || age < 18) {
            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
        }

        return new Adult(firstName, lastName, age);
    }
}
