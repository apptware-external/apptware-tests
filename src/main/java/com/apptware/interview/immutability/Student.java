/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Student {
  private String name;
  private Date dateOfBirth;
  private List<String> courses;
  
  
public Student(String name, Date dateOfBirth, List<String> courses) {
	super();
	this.name = name;
	this.dateOfBirth = dateOfBirth;
	this.courses = courses;
}


public String getName() {
	return name;
}


public Date getDateOfBirth() {
	return dateOfBirth;
}


public List<String> getCourses() {
	return courses;
}

  
}
