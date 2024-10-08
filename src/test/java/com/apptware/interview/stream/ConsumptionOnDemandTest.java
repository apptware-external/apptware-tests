package com.apptware.interview.stream;

import static com.apptware.interview.stream.PaginationService.FULL_DATA_SIZE;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ConsumptionOnDemandTest {

	// Mock the DataReader dependency
	@Mock
	private DataReader dataReader;

	// Initialize Mockito before tests
	public ConsumptionOnDemandTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testConsumptionOnDemand() {
		int limit = 1000;
		// List<String> limitedData = dataReader.fetchLimitadData(limit).toList();

		when(dataReader.fetchLimitadData(limit)).thenReturn(Stream.generate(() -> "data").limit(limit));

		when(dataReader.fetchFullData())
				.thenReturn(Stream.generate(() -> "data").limit(PaginationService.FULL_DATA_SIZE));

		// Perform assertions
		List<String> limitedData = dataReader.fetchLimitadData(limit).toList();

		Assertions.assertThat(limitedData).hasSize(limit);

		List<String> fullData = dataReader.fetchFullData().toList();
		Assertions.assertThat(fullData).hasSize(FULL_DATA_SIZE);

	}
}
