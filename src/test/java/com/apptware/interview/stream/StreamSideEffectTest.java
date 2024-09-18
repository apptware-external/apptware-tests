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
	  List<Integer> numbers = IntStream.range(1, 10)
              .boxed()
              .collect(Collectors.toList());
	  List<Integer> result =
    // DO NOT CHANGE >>>>>
     numbers.parallelStream()
        // <<<<< DO NOT CHANGE
        .map(number->number*2).collect(Collectors.toList());
    
    List<Integer> expectedResults = numbers.stream()
            .map(number -> number * 2)
            .collect(Collectors.toList());

    Assertions.assertThat(result).containsExactlyInAnyOrder(expectedResults.toArray(Integer[]::new));
  }
}
