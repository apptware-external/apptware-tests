/* This class is expected to be an entity class. Please ensure necessary changes are made related to JPA. */
package com.apptware.interview.jpa;

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
