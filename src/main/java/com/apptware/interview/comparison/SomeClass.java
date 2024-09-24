package com.apptware.interview.comparison;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Objects;
import java.io.Serializable;

@Data
@AllArgsConstructor
class SomeClass {

  // This is a unique identifier
  private Integer id;
  private Date lastInvoked;
  
  public SomeClass(int id, Date lastInvoked) {
      this.id = id;
      this.lastInvoked = lastInvoked;
  }

  public int getId() {
      return id;
  }

  public Date getLastInvoked() {
      return lastInvoked;
  }

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

  @Override
  public String toString() {
      return "SomeClass(id=" + id + ", lastInvoked=" + lastInvoked + ")";
  }
}
