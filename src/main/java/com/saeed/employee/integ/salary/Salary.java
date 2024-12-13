package com.saeed.employee.integ.salary;

import java.io.Serializable;

public record Salary(Long id, Long employeeId, double salary) implements Serializable {
}
