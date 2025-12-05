package com.demo.springmvcexample;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springmvcexample.model.Alien;

@Controller
public class AlienController {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
//	@RequestMapping("addalien")
//	public String addalien(@RequestParam int aid,@RequestParam String aname,Model m) {
//		Alien a =new Alien();     //${alien}
//		a.setAid(aid);
//		a.setAname(aname);
//		m.addAttribute("alien", a);
//		return "result";
//	}
	
	
//	@RequestMapping("addalien")
//	public String addalien(Alien a,Model m) {
//		m.addAttribute("alien", a);        //${alien}
//		return "result";
//	}
	
	@RequestMapping("addalien")
	public String addalien(@ModelAttribute("a")Alien a,Model m) {
		return "result";  // in result use ${a}
	}
	
	//model attribute at method level
	@ModelAttribute
	public void modeldate(Model m) {
		m.addAttribute("name", "Aliens");  
		//Result : ${a}
//		Welcome back ${name}
	}
	
	@GetMapping("get")
	public String getaliens(Model m) {
		List<Alien> aliens = Arrays.asList(new Alien(1,"Tejaswini"));
		m.addAttribute("result", aliens);
		return "showaliens";
	}
}
