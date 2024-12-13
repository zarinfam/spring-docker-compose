package com.saeed.employee.integ.salary;

import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SalaryClient {

    @Cacheable(value = "salaries")
    public Salary getSalaryByEmployeeId(Long employeeId) {
        return new Salary(null, employeeId, new Random().nextInt(9001) + 1000);
    }

}
