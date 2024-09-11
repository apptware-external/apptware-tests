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

        IntStream.range(1, 100000).forEach(numbers::add);
        // DO NOT CHANGE >>>>>
        List<Integer> results = numbers.parallelStream()
                // <<<<< DO NOT CHANGE
                .map(number -> number * 2)
                .collect(Collectors.toList());

        Assertions.assertThat(results).containsExactlyInAnyOrder(
                numbers.stream().map(n -> n * 2).toArray(Integer[]::new));
    }
}
