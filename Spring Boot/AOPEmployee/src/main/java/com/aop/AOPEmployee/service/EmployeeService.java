package com.aop.AOPEmployee.service;

import org.springframework.stereotype.Service;

import com.aop.AOPEmployee.model.Employee;

@Service
public class EmployeeService {

	public Employee createemployee(int empid,String firstname,String lastname) {
		
		
		if(empid<=0) {
			throw new RuntimeException("Invalid id");
		}
		Employee emp = new Employee();
		emp.setEmpId(empid);
		emp.setFirstname(firstname);
		emp.setLastname(lastname);
		return emp;
	}
	
	public void deleteemployee(int empid) {
		
	}
}
