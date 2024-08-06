package com.apptware.interview.jpa.employee;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
class Employee {

	@Id
	private UUID id;
	private String name;
}
