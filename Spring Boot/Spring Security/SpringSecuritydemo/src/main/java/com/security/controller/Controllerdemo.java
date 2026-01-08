package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
