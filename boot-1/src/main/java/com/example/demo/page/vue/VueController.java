package com.example.demo.page.vue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;


@Controller
public class VueController {
	@ApiOperation(value = "首页地址", httpMethod = "GET")
	@RequestMapping("/")
	public String index(Model model) {
		//使用@restController注解shi
	//	ModelAndView mv = new ModelAndView("index");
	    model.addAttribute("name", "hello boy");
		return "index";
	}
}
