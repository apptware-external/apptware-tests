package com.apptware.interview.comparison;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents a data entity with a unique identifier and a date.
 */
@Data
public class SomeClass {  // Ensure this class is public

    @Id
    private Integer id;
    private Date lastInvoked;

    public SomeClass(Integer id, Date lastInvoked) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeClass someClass = (SomeClass) o;
        return Objects.equals(id, someClass.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public static <T> List<T> toList(Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }
}
