package com.apptware.interview.jpa.employee;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
class Employee {

  @Id
  private UUID id;
  private String name;
}


/**
 * By annotating the id field, it enable JPA to perform operations such as saving and retrieving entities based on their primary key
 *  so it's resolved the issues seen in the test case.
 */