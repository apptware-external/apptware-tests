package com.apptware.interview.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamSideEffectTest {

  @Test
  void parallelStream() {
    List<Integer> numbers = new ArrayList<>();
    List<Integer> results = new ArrayList<>();

    IntStream.range(1, 10).forEach(numbers::add);
    // DO NOT CHANGE >>>>>
    numbers.parallelStream()
        // <<<<< DO NOT CHANGE
        .map(
            number -> {
              results.add(number);
              return number * 2;
            }).collect(Collectors.toList());

    Assertions.assertThat(numbers).containsExactlyInAnyOrder(results.toArray(Integer[]::new));
  }
}
