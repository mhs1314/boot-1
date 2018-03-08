package com.example.demo.page.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.factory.rabbitmq.service.MqService;
import com.example.demo.factory.user.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MqService mqService;

	@RequestMapping("/index")
	public String index(Model model) {
		//使用@restController注解shi
	//	ModelAndView mv = new ModelAndView("index");
	    model.addAttribute("name", "Dear");
		return "index";
	}
	
	@RequestMapping("/sendmq")
	public String sendmq(Model model) {
		mqService.send("hello");
		model.addAttribute("name", "Dear");
		return "index";
	}

	@RequestMapping("/login/{name}/{pass}")
	@ResponseBody
	public Object Login(@PathVariable("name") String name,@PathVariable("pass") String pass) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("pass", pass);
		return userService.queryUserByNamePWD(map);
	}
}
