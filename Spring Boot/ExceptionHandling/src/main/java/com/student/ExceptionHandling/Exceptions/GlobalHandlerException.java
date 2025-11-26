package com.student.ExceptionHandling.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.student.ExceptionHandling.model.ErrorResponse;

@RestControllerAdvice
public class GlobalHandlerException {

	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<ErrorResponse> studentnotfound(StudentNotFound snf,WebRequest webrequest){
		ErrorResponse errorresponse = new ErrorResponse(snf.getMessage(),
														webrequest.getDescription(false), 
														"STUDENT NOT FOUND");
		return new ResponseEntity<>(errorresponse,HttpStatus.NOT_FOUND);
	}
}
