package com.apptware.interview.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamSideEffectTest {

  @Test
  void parallelStream() {
    List<Integer> numbers = new ArrayList<>();
    List<Integer> results = Collections.synchronizedList(new ArrayList<>());

    IntStream.range(1, 100000).forEach(numbers::add);
    // DO NOT CHANGE >>>>>
    numbers.parallelStream()
        // <<<<< DO NOT CHANGE
        .forEach(results::add);

    Assertions.assertThat(numbers).containsExactlyInAnyOrder(results.toArray(Integer[]::new));
  }
}
