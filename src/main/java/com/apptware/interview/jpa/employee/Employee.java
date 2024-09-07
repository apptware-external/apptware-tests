package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
class Employee {

  @Id
  private UUID id;
  private String name;
}
