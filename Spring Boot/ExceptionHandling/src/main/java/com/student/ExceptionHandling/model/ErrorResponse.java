package com.student.ExceptionHandling.model;


import java.time.LocalTime;

public class ErrorResponse {

	private LocalTime timestamp;
	private String errormsg;
	private String errordetails;
	private String errorcode;
	public ErrorResponse(String errormsg, String errordetails, String errorcode) {
		super();
		this.timestamp=LocalTime.now();
		this.errormsg = errormsg;
		this.errordetails = errordetails;
		this.errorcode = errorcode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getErrordetails() {
		return errordetails;
	}
	public void setErrordetails(String errordetails) {
		this.errordetails = errordetails;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public LocalTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
