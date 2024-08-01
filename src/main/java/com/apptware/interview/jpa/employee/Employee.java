package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
class Employee {

  @Id // for  primary  key
  private UUID id;  // no default value
  private String name;

  public Employee(String name) {
    this.name = name;
    this.id = UUID.randomUUID(); // creating UUId, every employee can unique and identified.
  }
}
