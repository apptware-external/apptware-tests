package com.apptware.interview.comparison;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class SomeClass {

  // This is a unique identifier
	 @EqualsAndHashCode.Include
  private Integer id;
  private Date lastInvoked;
}
