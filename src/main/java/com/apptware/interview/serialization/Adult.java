package com.apptware.interview.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.StandardException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.json.JacksonJsonParser;

@Data
@NoArgsConstructor
@JsonDeserialize(using = Adult.AdultDeserializer.class)
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

    public static class AdultDeserializer extends JsonDeserializer<Adult> {
        @Override
        @SneakyThrows
        public Adult deserialize(JsonParser jp, DeserializationContext ctxt) {
            JsonNode node = jp.getCodec().readTree(jp);

            if (StringUtils.isBlank(node.get("firstName").asText()) || StringUtils.isBlank(node.get("lastName").asText())) {
                throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
            }
            if (Objects.isNull(node.get("age")) || Integer.parseInt(node.get("age").toString()) < 18) {
                throw new IllegalArgumentException("Inappropriate Age for an Adult.");
            }

            String firstname = node.get("firstname").asText();
            String lastname = node.get("lastname").asText();
            Integer age = node.get("age").asInt();

            return new Adult(firstname, lastname, age);
        }
    }
}
