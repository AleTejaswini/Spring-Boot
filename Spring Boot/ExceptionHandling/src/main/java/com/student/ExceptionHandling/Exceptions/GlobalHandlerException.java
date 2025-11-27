package com.student.ExceptionHandling.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlevalidationerror(MethodArgumentNotValidException ex,WebRequest webrequest){
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors()
		.forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
		
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
