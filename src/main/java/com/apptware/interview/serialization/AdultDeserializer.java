package com.apptware.interview.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class AdultDeserializer extends StdDeserializer<Adult> {

    public AdultDeserializer() {
        this(null);
    }

    public AdultDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Adult deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String firstName = node.get("firstName").asText();
        String lastName = node.get("lastName").asText();
        Integer age = node.get("age").asInt();

        return new Adult(firstName, lastName, age);
    }

}
