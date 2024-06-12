package com.apptware.interview.jpa.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

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

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
