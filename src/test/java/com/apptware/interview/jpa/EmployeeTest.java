package com.apptware.interview.jpa;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * This test class has a validation for {@link com.apptware.interview.jpa.Employee}.
 * This test verifies the save operation for the Employee entity. It creates an Employee object,
 * saves it using the EmployeeRepository, and then retrieves the stored Employee object to ensure
 * the integrity of its parameters.
 *
 * <p>The candidate is expected **NOT** to modify the test case but the corresponding class for
 * which the test case is written.
 */
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
