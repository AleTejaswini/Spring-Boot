package com.mvc.MVC_CompanyPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.MVC_CompanyPortal.model.User;
@Controller
public class UserController {

	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@PostMapping("/dashboard")
	public String dashboard(@ModelAttribute("user") User u , Model m){
		m.addAttribute("user", u);
		return "dashboard";
	}
}
