package com.example.demo.page.rabbitmq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.factory.rabbitmq.service.MqService;

/**
 * rabbitmq服务接口
 * 
 * @author mhs123
 *
 */
@Controller
@RequestMapping("rabbitmq")
public class RabbitmqController {
	@Autowired
	private MqService mqService;

	// Queue发送方式--平均分配给消费者
	@RequestMapping("/queue_send")
	public String queue_send(Map<String, Object> map) {
		map.put("name", "queue_hello"); 
		//RPC方案
		//请求id用于标记消息记录，返回时校验
		map.put("id", "123"); 
		mqService.queue_send(map);
		return "index";
	}

	// fanout发送方式--接收者均接收到信息。
	@RequestMapping("/fanout_send")
	public String fanout_send(Map<String, Object> map) {
		map.put("name", "fanout_hello");
		mqService.fanout_send(map);
		return "index";
	}

	// Topic发送方式接收到A接收到发送者A的信息
	@RequestMapping("/topic_send")
	public String topic_send(Map<String, Object> map) {
		map.put("name", "topic_hello");
		mqService.topic_send(map);
		return "index";
	}
}
