package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import java.util.UUID;
import jakarta.persistence.Id;

@Entity
class Employee {

  //added the Id annotation for the declaring id is the primary key
  @Id
  private UUID id;
  private String name;

  //Added Getter and Setter methods for the fields
  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
