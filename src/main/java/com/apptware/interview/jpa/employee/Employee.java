package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
class Employee {

  @Id
  private UUID id;
  private String name;
  
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
