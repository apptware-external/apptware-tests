package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.DataReader;
import com.apptware.interview.stream.PaginationService;
import jakarta.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataReaderImpl implements DataReader {

	@Autowired private PaginationService paginationService;

	@Override
	public Stream<String> fetchLimitadData(int limit) {
		return fetchPaginatedDataAsStream().limit(limit);
	}

	@Override
	public Stream<String> fetchFullData() {
		return fetchPaginatedDataAsStream();
	}
	private @Nonnull Stream<String> fetchPaginatedDataAsStream() {
		log.info("Fetching paginated data as stream.");

		List<String> allData = new ArrayList<>();
		int pageNumber = 1;
		List<String> pageData;

		do {
			pageData = paginationService.getPaginatedData(pageNumber, 100);
			if (!pageData.isEmpty()) {
				allData.addAll(pageData);
				log.info("Fetched page {} with {} items", pageNumber, pageData.size());
			}
			pageNumber++;
		} while (!pageData.isEmpty());

		return allData.stream().peek(item -> log.info("Fetched Item: {}", item));
	}
}
