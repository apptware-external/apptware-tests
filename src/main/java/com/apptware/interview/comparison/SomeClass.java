package com.apptware.interview.comparison;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
class SomeClass {

  // This is a unique identifier
  private Integer id;
  private Date lastInvoked;
  
  
  
@Override
public int hashCode() {
	return id;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SomeClass other = (SomeClass) obj;
	return this.hashCode() == obj.hashCode();
}

public SomeClass(Integer id, Date lastInvoked) {
	super();
	this.id = id;
	this.lastInvoked = lastInvoked;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getLastInvoked() {
	return lastInvoked;
}
public void setLastInvoked(Date lastInvoked) {
	this.lastInvoked = lastInvoked;
}

  
}
