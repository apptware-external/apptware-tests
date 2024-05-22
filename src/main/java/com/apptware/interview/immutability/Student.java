/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
	private final String name;
	private final Date dateOfBirth;
	private final List<String> courses;


	public List<String> getCourses()
	{
		List<String> refCourses = new ArrayList<>(this.courses);;
		return refCourses;
	}

	public Date getDateOfBirth() {
		Date refDateOfBirth = new Date(this.dateOfBirth.getTime());
		return refDateOfBirth;
	}


}
