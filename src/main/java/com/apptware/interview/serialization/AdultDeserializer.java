package com.apptware.interview.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class AdultDeserializer extends JsonDeserializer<Adult> {

    @Override
    public Adult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        // Custom deserialization logic here
        return null;
    }
}
