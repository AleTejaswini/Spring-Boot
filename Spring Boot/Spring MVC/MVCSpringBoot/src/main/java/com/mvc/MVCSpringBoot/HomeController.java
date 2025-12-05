package com.mvc.MVCSpringBoot;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // loads home.jsp
    }

    @GetMapping("add")
    public String add(int num1, int num2, Model model) {

        int result = num1 + num2;
        model.addAttribute("result", result);

        return "result";  // loads result.jsp
    }
    
    
    
}
