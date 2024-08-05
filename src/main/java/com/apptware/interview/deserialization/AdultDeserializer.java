package com.apptware.interview.deserialization;

import java.io.IOException;

import com.apptware.interview.serialization.Adult;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import io.micrometer.common.util.StringUtils;

public class AdultDeserializer extends JsonDeserializer<Adult>{

	@Override
	public Adult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		 	JsonNode node = p.getCodec().readTree(p);
		 
	        String firstName = node.get("firstName").asText();
	        String lastName = node.get("lastName").asText();
	        Integer age = (node.get("age") != null) ? node.get("age").asInt() : null;
	        
	        if ((StringUtils.isBlank(firstName) || firstName.equalsIgnoreCase("")) || (StringUtils.isBlank(lastName) || lastName.equalsIgnoreCase(""))) {
	            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
	        }
	        if (age == null || age < 18) {
	            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
	        }
	        
	        return new Adult(firstName, lastName, age);
	     
	}
	

}
