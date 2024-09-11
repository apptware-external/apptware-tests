package com.apptware.interview.comparison;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class SomeClass {

  // This is a unique identifier
  private Integer id;
  private Date lastInvoked;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SomeClass someClass = (SomeClass) o;
    return id == someClass.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
