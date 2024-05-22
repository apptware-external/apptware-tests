package com.apptware.interview.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

public class AdultDeserializer extends StdDeserializer<Adult> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdultDeserializer() { 
		this(null); 
	} 

	public AdultDeserializer(Class<?> vc) { 
		super(vc); 
	}

	@Override
	public Adult deserialize(JsonParser jp, DeserializationContext ctxt) 
			throws IOException, JsonProcessingException {

		JsonNode node = jp.getCodec().readTree(jp);
		String firstName = node.get("firstName").asText();
		String lastName = node.get("lastName").asText();
		int age = (Integer) ((IntNode) node.get("age")).numberValue();

		return new Adult(firstName, lastName, age);
	}



}
