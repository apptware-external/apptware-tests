package com.apptware.interview.singleton;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

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
  void testSingleton() {
    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();

    Assertions.assertThat(instance1).isSameAs(instance2);
  }
}