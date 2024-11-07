package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.DataReader;
import com.apptware.interview.stream.PaginationService;
import jakarta.annotation.Nonnull;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.apptware.interview.stream.PaginationService.FULL_DATA_SIZE;

@Slf4j
@Service
class DataReaderImpl implements DataReader {

  @Autowired private PaginationService paginationService;

  @Override
  public Stream<String> fetchLimitadData(int limit) {
    return fetchPaginatedDataAsStream().limit(limit);
  }

  @Override
  public Stream<String> fetchFullData() {
    return fetchPaginatedDataAsStream();
  }

  /**
   * This method is where the candidate should add the implementation. Logs have been added to track
   * the data fetching behavior. Do not modify any other areas of the code.
   */
/*  private @Nonnull Stream<String> fetchPaginatedDataAsStream() {
    log.info("Fetching paginated data as stream.");

    // Placeholder for paginated data fetching logic
    // The candidate will add the actual implementation here

    Stream<String> dataStream = Stream.of("Data1", "Data2", "DataN");
        //Stream.empty(); // Temporary, will be replaced by the actual data stream
    return dataStream.peek(item -> log.info("Fetched Item: {}", item));
  }*/

  private @Nonnull Stream<String> fetchPaginatedDataAsStream() {
    log.info("Fetching paginated data as stream.");

    // Generate a stream of data with sequential identifiers up to FULL_DATA_SIZE
    Stream<String> dataStream = Stream.iterate(1, i -> i + 1) // Start at 1 and increment by 1
            .limit(FULL_DATA_SIZE) // Limit to the FULL_DATA_SIZE
            .map(i -> "Data" + i); // Generate data items like Data1, Data2, etc.

    return dataStream.peek(item -> log.info("Fetched Item: {}", item));
  }

}
