package com.apptware.interview.comparison;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Objects;

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
      return Objects.equals(id, someClass.id);
  }

  @Override
  public int hashCode() {
      return Objects.hash(id);
  }
  
  @Override
  public String toString() {
      return "SomeClass{" +
              "id=" + id +
              ", lastInvoked=" + lastInvoked +
              '}';
  }
}
