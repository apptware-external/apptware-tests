/** This class is expected to be immutable. Please make necessary changes. */
package com.apptware.interview.immutability;

import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public final class Student {
    private final String name;
    private final Date dateOfBirth;
    private final List<String> courses;

    // Constructor
    public Student(String name, Date dateOfBirth, List<String> courses) {
        this.name = name;
        this.dateOfBirth = new Date(dateOfBirth.getTime()); // Defensive copy
        this.courses = Collections.unmodifiableList(new ArrayList<>(courses)); // Defensive copy
    }

    // Getters
    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime()); // Defensive copy
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }
}

/**
 * Implemented below changes to make this class Immutable
 * 
 * The class and all fields are marked final, so they cannot be changed after construction.
 * The constructor and getter methods return copies of mutable objects like Date and List, preventing changes to the internal state.
 * The list of courses is made immutable using Collections.unmodifiableList, ensuring it cannot be modified from outside.
 */
