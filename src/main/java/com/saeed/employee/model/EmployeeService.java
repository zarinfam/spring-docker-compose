package com.saeed.employee.model;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saeed.employee.api.model.EmployeeModel;
import com.saeed.employee.integ.salary.Salary;
import com.saeed.employee.integ.salary.SalaryClient;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final SalaryClient salaryClient;

    public EmployeeService(EmployeeRepository employeeRepository, SalaryClient salaryClient) {
        this.employeeRepository = employeeRepository;
        this.salaryClient = salaryClient;
    }

    public EmployeeModel findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> mapToModel(employee, salaryClient.getSalaryByEmployeeId(employeeId)))
                .orElseThrow(() -> new RuntimeException("Employee not found!"));
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    private EmployeeModel mapToModel(Employee employee, Salary salary) {
        return new EmployeeModel(employee.id(), employee.fullName(), Optional.of(salary.salary()));
    }
}
