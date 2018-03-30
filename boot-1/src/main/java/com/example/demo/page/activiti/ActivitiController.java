package com.example.demo.page.activiti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.factory.activiti.service.ActivityConsumerService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("activiti") 
public class ActivitiController {
	@Autowired
	private ActivityConsumerService acService;
	
	@ApiOperation(value = "流程demo", httpMethod = "GET")
	@RequestMapping("/startActivityDemo")
	@ResponseBody
	public String startActivityDemo(Model model) {
		return acService.startActivityDemo();
	}
}
