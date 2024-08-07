package com.apptware.interview.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test class has a validation for {@link com.apptware.interview.serialization.Adult}. The
 * first test tests the validation using a constructor by creating an illegal entity and expecting
 * an error message for the same. The second test has a same purpose using serialization.
 *
 * <p>The candidate is expected to modify the test case and the corresponding class for which the
 * test case is written so that the appropriate exception is thrown with appropriate messages.
 */
public class AdultTest {

    @Test
    public void testConstructorValidation() {
        String json1 = """
            {
              "firstName": "",
              "lastName": "",
              "age": 18
            }
            """;

        String json2 = """
            {
              "firstName": "Firstname",
              "lastName": "Lastname",
              "age": 17
            }
            """;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Adult adult = objectMapper.readValue(json1, Adult.class);
            fail("Expected IllegalArgumentException");
        } catch (JsonMappingException e) {
            Throwable cause = e.getCause();
            assertEquals(IllegalArgumentException.class, cause.getClass());
            assertEquals("Firstname or Lastname CANNOT be blank.", cause.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            Adult adult = objectMapper.readValue(json2, Adult.class);
            fail("Expected IllegalArgumentException");
        } catch (JsonProcessingException e) {
            Throwable cause = e.getCause();
            assertEquals(IllegalArgumentException.class, cause.getClass());
            assertEquals("Inappropriate Age for an Adult.", cause.getMessage());
        }
    }
}