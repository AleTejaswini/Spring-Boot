package com.csvtoMysql.BatchProcessing.processor;

import org.springframework.batch.item.ItemProcessor;

import com.csvtoMysql.BatchProcessing.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee,Employee> {

    @Override
    public Employee process(Employee emp) {

        if ("FullTime".equalsIgnoreCase(emp.getJobType())) {
            emp.setSalary(50000);
        } else {
            emp.setSalary(25000);
        }

        return emp;
    }
}
