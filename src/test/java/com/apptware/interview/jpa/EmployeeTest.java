package com.apptware.interview.jpa;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class EmployeeTest {
  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeTest(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }
  @Test
  void testSaveEmployee() {
    Employee employee = new Employee();
    UUID empId = UUID.randomUUID();
    employee.setId(empId);
    employee.setName("Emp Name");

    employeeRepository.save(employee);

    Employee retrievedEmployee = employeeRepository.findById(empId).orElse(null);

    assertThat(retrievedEmployee.getId()).isEqualTo(empId);
    assertThat(retrievedEmployee).isNotNull();
    assertThat(retrievedEmployee.getName()).isEqualTo("Emp Name");
  }
}
