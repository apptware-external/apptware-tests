package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

  private UUID id;
  private String name;
}
