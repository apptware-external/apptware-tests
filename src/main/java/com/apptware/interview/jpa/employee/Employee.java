package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;

import java.util.UUID;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
class Employee {
  /**
   * Annotating the id field allows JPA to handle entity operations.
   * test case issue resolved.
   */
    @Id
    private UUID id;
    private String name;
}
