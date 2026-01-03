package com.aop.BankAOP.aspect;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Component;

import com.aop.BankAOP.entity.Account;

@Aspect
@Component
public class AccountServiceAspect {

//	@Before(value = "execution(* com.aop.BankAOP.service.AccountService.*(..))")
//	public void beforeadvice(JoinPoint jp) {
//		System.out.println("Before Method: "+jp.getSignature());
//		System.out.println("Method started successfully");
//	}
//	@After(value = "execution(* com.aop.BankAOP.service.AccountService.*(..))")
//	public void afteradvice(JoinPoint jp) {
//		System.out.println("After Method: "+jp.getSignature());
//		System.out.println("Method executed successfully");
//	}
//	afterreturning for createmethod
	@AfterReturning(pointcut = "execution(* com.aop.BankAOP.service.AccountService.addaccount(..))",returning = "account")
	public void afterreturning(JoinPoint jp,Account account) {
		System.out.println("After Returning : "+jp.getSignature());
		System.out.println("Account created successfully ");
		System.out.println("Account num: "+account.getAccNum());
		System.out.println("Account balance: "+account.getBalance());
	}
	
	@AfterThrowing(pointcut = "execution(* com.aop.BankAOP.AccountService.*(..))",throwing = "exception")
	public void afterthrowing(Account account,Exception exception) {
		System.out.println("After throwing exception");
		System.out.println("Exception occured :"+exception.getMessage());
	}
	
//	afterreturning for getaccount
	@AfterReturning(pointcut = "execution(* com.aop.BankAOP.service.AccountService.getaccounts(..))" ,returning = "accounts")
	public void afterreturninggetall(JoinPoint jp ,List<Account> accounts) {
		System.out.println("After Returning : "+jp.getSignature());
		System.out.println("ALL Account details got successfully ");
		for(Account account: accounts) {
		System.out.println("Account num: "+account.getAccNum());
		System.out.println("Account balance: "+account.getBalance());
	}}
	
	//afterreturning for getaccount
	@AfterReturning(pointcut = "execution (* com.aop.BankAOP.service.AccountService.getaccount(..))",returning = "account")
	public void afterreturningget(JoinPoint jp,Account account) {
		System.out.println("After Returning :"+jp.getSignature());
		System.out.println("Account details got successfully");
		System.out.println("Account num: "+account.getAccNum());
		System.out.println("Account balance: "+account.getBalance());
	}
	
	@Around(value = "execution(* com.aop.BankAOP.service.AccountService.*(..))")
	public Object aroundadvice(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("Around Method: "+jp.getSignature());
		long start = System.currentTimeMillis();
		System.out.println("Before Method: "+jp.getSignature());
		System.out.println("Method started successfully at " +start);
		
		Object result = jp.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("After Method: "+jp.getSignature());
		System.out.println("Method executed successfully at "+end);
		
		return result;
	}
	
}
