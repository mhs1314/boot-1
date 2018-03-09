package com.example.demo.consumer.rabbimq;

import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	// 以下是验证没有加入 Exchange的队列
	@RabbitListener(queues = "hello")
	public void queues_process_1(Map<String, Object> msg) {
		System.out.println(String.format("queues_process_1 object: %s", msg));
		//RPC方案
		//返回消息处理成功
		msg.put("res", "ok");
		this.rabbitTemplate.convertAndSend("hello", msg);
	}

	@RabbitListener(queues = "hello")
	public void queues_process_2(Map<String, Object> msg) {
		System.out.println(String.format("queues_process_2 object: %s", msg));
	}

	// 以下是验证FanoutExchange的队列
	// 接收者A
	@RabbitListener(queues = "fanout.A")
	public void fanout_process_a(Map<String, Object> msg) {
		System.out.println(String.format("fanout_process_a object: %s", msg));
	}

	// 接收者B
	@RabbitListener(queues = "fanout.B")
	public void fanout_process_b(Map<String, Object> msg) {
		System.out.println(String.format("fanout_process_b object: %s", msg));
	}

	// 接收者B
	@RabbitListener(queues = "fanout.C")
	public void fanout_process_c(Map<String, Object> msg) {
		System.out.println(String.format("fanout_process_c object: %s", msg));
	}

	// 以下是验证topic Exchange的队列
	// 只能接受topic.message的消息
	@RabbitListener(queues = "topic.message")
	public void topic_process_message(Map<String, Object> msg) {
		System.out.println(String.format("topic_process_message object: %s", msg));
	}

	// 接受所有topic.开头的消息
	@RabbitListener(queues = "topic.messages")
	public void topic_process_messages(Map<String, Object> msg) {
		System.out.println(String.format("topic_process_messages object: %s", msg));
	}

}