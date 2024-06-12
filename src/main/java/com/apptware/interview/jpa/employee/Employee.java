package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
class Employee {

  private UUID id;
  private String name;
}
