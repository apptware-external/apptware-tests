package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
class Employee {

  @Id
  private UUID id;
  private String name;
}
