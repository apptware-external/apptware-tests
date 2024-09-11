package com.apptware.interview.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The code tests whether the {@link com.apptware.interview.singleton.Singleton} class strictly
 * enforces the singleton pattern. By using reflection to access the private constructor, it
 * attempts to create a second instance of the singleton. The assertion at the end verifies whether
 * both instances are indeed the same, based on their hash codes. If the assertion fails, it
 * indicates a failure in the Singleton pattern implementation.
 *
 * <p>The candidate is expected **NOT** to modify the test case but the corresponding class for
 * which the test case is written.
 */
class SingletonTest {

  @Test
  @SneakyThrows
  void testSingleton() {
    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = null;

    Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
    for (Constructor<?> constructor : constructors) {
      constructor.setAccessible(true);
      try {
        instance2 = (Singleton) constructor.newInstance();
      } catch (InvocationTargetException e) {
        // Handle the exception thrown by the Singleton constructor
        // In a proper Singleton pattern, this exception should indicate that
        // the constructor cannot be invoked, confirming Singleton behavior
        assertTrue(e.getCause() instanceof IllegalStateException);
        return;
      }
    }

    // Verify that instance1 and instance2 are the same instance
    Assertions.assertThat(instance1).isSameAs(instance2);
  }
}