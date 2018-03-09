package com.example.demo.page.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.factory.rabbitmq.service.MqService;
/**
 * rabbitmq服务接口
 * @author mhs123
 *
 */
@Controller
@RequestMapping("rabbitmq")
public class RabbitmqController {
	@Autowired
	private MqService mqService;
	
	@RequestMapping("/queue_send")
	public String queue_send(Model model) {
		mqService.queue_send("queue_hello");
		model.addAttribute("name", "Dear");
		return "index";
	}
}
