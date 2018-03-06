package com.example.demo.page.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.factory.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index() {
		return " boot";
	}

	@RequestMapping("/login")
	@ResponseBody
	public Object Login() {
		return userService.queryUserByNamePWD("root", "123456");
	}
}
