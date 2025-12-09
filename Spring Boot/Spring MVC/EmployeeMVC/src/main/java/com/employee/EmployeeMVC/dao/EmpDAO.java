package com.employee.EmployeeMVC.dao;

import java.util.ArrayList;
import java.util.List;

import com.employee.EmployeeMVC.model.Employee;

public class EmpDAO {
List<Employee> emplist = new ArrayList<>();
	
	public void add(Employee e) {
		emplist.add(e);
	}
	
	public Employee getById( int empid) {
		for(Employee e:emplist) {
			if(e.getEmpid() == empid) {
				return e;
			}
			
		}return null;
	}
		
		 public List<Employee> getAll(){
			 return emplist;
		 }
		
		
		public void delete(int empid) {
			emplist.removeIf(e->e.getEmpid()==empid);
		
			
		}
			public void update(int empid,Employee e) {
				for(Employee emp:emplist) {
					if(emp.getEmpid() == empid) {
						emp.setEmpname(e.getEmpname());
					}
		}
			}
}
