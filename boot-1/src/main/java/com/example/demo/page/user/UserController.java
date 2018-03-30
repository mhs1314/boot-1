package com.example.demo.page.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.factory.user.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(Model model) {
		//使用@restController注解shi
	//	ModelAndView mv = new ModelAndView("index");
	    model.addAttribute("name", "Dear");
		return "index";
	}


	@RequestMapping("/list/user")
	@ResponseBody
	public Object getlist() {
		//返回分页信息
		return userService.queryUsers().toPageInfo();
	}
}
