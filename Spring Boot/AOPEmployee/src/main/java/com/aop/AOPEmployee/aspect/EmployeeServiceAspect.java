package com.aop.AOPEmployee.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.aop.AOPEmployee.model.Employee;

@Aspect
@Component
public class EmployeeServiceAspect {
//	
//	@Before(value = "execution(* com.aop.AOPEmployee.service.EmployeeService.*(..)) and args(empid,firstname,lastname)")
//	public void beforeadvice(JoinPoint joinpoint, int empid,String firstname,String lastname) {
//		System.out.println("Before Method: "+ joinpoint.getSignature());
//		System.out.println("Creating Employee with Empid: "+empid + " firstname: "+firstname +" lastname: "+lastname);
//		
//	}
//	@After(value ="execution(* com.aop.AOPEmployee.service.EmployeeService.*(..)) and args(empid)")
//	public void afteradvice(JoinPoint joinpoint , int empid) {
//		System.out.println("After method: " +joinpoint.getSignature() );
//		System.out.println("Deleted emp with Empid: "+empid);
//	}
//	
//	@Around(value = "execution(* com.aop.AOPEmployee.service.EmployeeService.*(..)) and args(empid,firstname,lastname)")
//	public Object aroundadvice(ProceedingJoinPoint jp,int empid,String firstname,String lastname) throws Throwable{
//		
//		System.out.println("Before Method: "+ jp.getSignature());
//		System.out.println("Creating Employee with Empid: "+empid + " firstname: "+firstname +" lastname: "+lastname);
//		
//		Object emp =  jp.proceed();
//		System.out.println("After method: " +jp.getSignature() );
//		System.out.println("Created emp with Empid: "+empid + " successfully");
//		
//		return emp;
//	}
	
	@AfterReturning(pointcut = "execution(* com.aop.AOPEmployee.service.EmployeeService.createemployee(..))", returning = "emp")
	public void afterreturning(JoinPoint jp ,Employee emp) {
		System.out.println("after returning :" + jp.getSignature());
		System.out.println("Employee created successfully");
		System.out.println("Employee Id: "+emp.getEmpId());
		System.out.println("Employee firstname: "+emp.getFirstname());
		System.out.println("Employee lastname: "+emp.getLastname());
	}
	
	@AfterThrowing(value = "execution(* com.aop.AOPEmployee.service.EmployeeService.createemployee(..))" ,throwing="exception") 
	public void afterthrowing(JoinPoint jp , Exception exception) {
		System.out.println("After throwing: "+jp.getSignature());
		System.out.println("Exception occurred: "+exception.getMessage());
	}
	
}
