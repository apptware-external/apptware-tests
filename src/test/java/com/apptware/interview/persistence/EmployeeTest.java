package com.apptware.interview.persistence;

import jakarta.persistence.PersistenceException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeTest {
  @Autowired

  private EmployeeRepository employeeRepository;

  @Test
  void testSaveEmployeeWithoutIdAnnotation() {
    Employee employee = new Employee();
    UUID id = UUID.randomUUID();
    employee.setId(id);
    employee.setName("John Doe");

    org.assertj.core.api.Assertions.assertThatThrownBy(
            () -> {
              employeeRepository.save(employee);
            }
        ).isInstanceOf(PersistenceException.class)
        .hasMessage("Entity not saved !");
  }
}
