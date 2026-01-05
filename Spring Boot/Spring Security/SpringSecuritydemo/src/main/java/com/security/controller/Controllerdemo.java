package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllerdemo {

	@GetMapping("/welcome")
	public String  welcome() {
		return "Welcome to Spring security";
	}
}
