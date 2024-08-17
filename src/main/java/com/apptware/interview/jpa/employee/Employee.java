package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Entity
class Employee {
@Id
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
private UUID id;
  private String name;
}
