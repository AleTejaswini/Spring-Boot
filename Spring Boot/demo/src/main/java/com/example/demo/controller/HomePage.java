package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {
	// static
//	@RequestMapping("/index")
//	public String index() {
//		return "index.html";
//	}
	//dynamic
	@RequestMapping("/dynamicindex")
	public String index(Model model) {
		model.addAttribute("name", "Teja");
		return "index";
	}
	
}
