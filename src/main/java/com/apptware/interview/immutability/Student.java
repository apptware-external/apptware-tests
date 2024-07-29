/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Student {
  private String name;
  private Date dateOfBirth;
  private List<String> courses;

  public Student(String nae,Date dateOfBirth,List<String> courses){
    this.name=name;
    this.dateOfBirth=new Date(dateOfBirth.getTime());
    this.courses= Collections.unmodifiableList(courses);
  }

  public Date getDateOfBirth(){
    return  new Date(dateOfBirth.getTime());
  }
}
