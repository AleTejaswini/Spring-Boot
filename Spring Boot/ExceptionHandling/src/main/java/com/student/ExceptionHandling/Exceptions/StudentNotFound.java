package com.student.ExceptionHandling.Exceptions;

public class StudentNotFound extends RuntimeException{

	public StudentNotFound(String message) {
		super(message);
	}
}
