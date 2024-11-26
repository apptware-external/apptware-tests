package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.DataReader;
import com.apptware.interview.stream.PaginationService;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class DataReaderImpl implements DataReader {

  @Autowired private PaginationService paginationService;

  @Override
  public Stream<String> fetchFullData() {
      return fetchPaginatedDataAsStream();
  }

  private @Nonnull Stream<String> fetchPaginatedDataAsStream() {
      log.info("Fetching paginated data as stream.");

      int page = 1;
      int pageSize = 1000; 
      List<String> paginatedData;

      Stream.Builder<String> dataStreamBuilder = Stream.builder();

      do {
          paginatedData = paginationService.getPaginatedData(page, pageSize);
          log.info("Fetched {} items for page {}", paginatedData.size(), page);
          paginatedData.forEach(dataStreamBuilder::add);
          page++;
      } while (!paginatedData.isEmpty());

      return dataStreamBuilder.build();
  }

  @Override
  public Stream<String> fetchLimitedData(int limit) {
    return fetchPaginatedDataAsStream().limit(limit);
  }
}
