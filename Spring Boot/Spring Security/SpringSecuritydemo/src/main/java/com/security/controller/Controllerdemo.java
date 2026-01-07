package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllerdemo {

	@GetMapping("/welcome")
	public String  welcome() {
		return "Welcome to Spring security";
	}
	
	@GetMapping("/public/hello")
	public String hello() {
		return "Hello public -No login";
	}
	
	@GetMapping("/secure/hello")
	public String secure() {
		return "Hello public - with login";
	}
}
