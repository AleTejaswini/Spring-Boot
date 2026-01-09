package com.security.SpringSecurityUserEx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.SpringSecurityUserEx.entity.Users;
import com.security.SpringSecurityUserEx.service.UserService;



@RestController
public class UserController {
	@Autowired
	private UserService userservice;

	@PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userservice.saveuser(user);
    }		
	
	@GetMapping("/public")
	public String publicapi() {
		return "This is public api";
	}
	
	@GetMapping("/secure")
	public String secureapi() {
		return "This is secure api";
		
	}
}
