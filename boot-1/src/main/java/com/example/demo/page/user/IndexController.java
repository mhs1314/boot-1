package com.example.demo.page.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		//使用@restController注解shi
	//	ModelAndView mv = new ModelAndView("index");
	    model.addAttribute("name", "hello boy");
		return "index";
	}
}
