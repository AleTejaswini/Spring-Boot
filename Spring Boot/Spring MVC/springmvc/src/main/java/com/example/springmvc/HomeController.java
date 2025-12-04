package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
//	@RequestMapping("add")
//	public String addition(@RequestParam("num1")int i,@RequestParam("num2")int j,HttpSession session) {
//		
//		int num3 = i+j;
//		
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//	}
	
	//without HttpSession
//	@RequestMapping("add")
//	public ModelAndView addition(@RequestParam("num1")int i,@RequestParam("num2")int j) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		int num3 = i+j;
//		mv.addObject("num3",num3);
//		return mv;
//	}	
//	
	
	//Model and ModelMap
	//Model
//	@RequestMapping("add")
//	public String addition(@RequestParam("num1")int i,@RequestParam("num2")int j,Model m) {
//		int num3 = i+j;
//		m.addAttribute("num3",num3);
//		
//		return "result";
//	}
	//ModelMap
	@RequestMapping("add")
	public String addition(@RequestParam("num1")int i,@RequestParam("num2")int j,ModelMap m) {
		int num3 = i+j;
		m.addAttribute("num3",num3);
		return "result";
	}
	
}
