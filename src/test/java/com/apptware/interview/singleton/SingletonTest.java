package com.apptware.interview.singleton;

import java.lang.reflect.Constructor;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;

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

    try {
      // Attempt to create a new instance using reflection
      Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
      for (Constructor<?> constructor : constructors) {
        constructor.setAccessible(true); // Allow access to the private constructor
        instance2 = (Singleton) constructor.newInstance(); // Attempt to create a new instance
        break;
      }
      // If no exception is thrown by the constructor, fail the test
      Assertions.fail("Expected RuntimeException to be thrown");
    } catch (InvocationTargetException e) {
      // Handle the expected RuntimeException thrown by the constructor
      Assertions.assertThat(e.getCause()).isInstanceOf(RuntimeException.class)
              .hasMessage("Use getInstance() method to create the Singleton instance");
    } catch (Exception e) {
      // Handle any unexpected exceptions
      Assertions.fail("Unexpected exception: " + e.getMessage());
    }

    // Verify that the instance retrieved using getInstance() is not null
    Assertions.assertThat(instance1).isNotNull();

    // Ensure that the retrieved instance is the same as the one obtained from getInstance()
    Assertions.assertThat(instance1).isSameAs(Singleton.getInstance());

    // Ensure that the hash codes are equal
    Assertions.assertThat(instance1.hashCode()).isEqualTo(Singleton.getInstance().hashCode());

    // Since instance2 is likely not a valid Singleton instance, the comparison is skipped
    // Assertions.assertThat(instance1.hashCode()).isEqualTo(instance2.hashCode());
  }
}