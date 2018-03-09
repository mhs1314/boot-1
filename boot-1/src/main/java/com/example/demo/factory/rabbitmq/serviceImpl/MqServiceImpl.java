package com.example.demo.factory.rabbitmq.serviceImpl;

import java.util.Date;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.factory.rabbitmq.service.MqService;

@Component
@Service
public class MqServiceImpl implements MqService {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Override
	public void queue_send(Map<String, Object> msg) {
		// TODO Auto-generated method stub
		System.out.println(String.format("queue_send object: %s", msg));
		this.rabbitTemplate.convertAndSend("hello", msg);
	}

	@Override
	public void fanout_send(Map<String, Object> msg) {
		// TODO Auto-generated method stub
		System.out.println("fanout_send : " + msg);
		//指定消费者也没用都会发送给所有消费者
		this.rabbitTemplate.convertAndSend("fanoutExchange", "fanout.A", msg);
	}

	@Override
	public void topic_send(Map<String, Object> msg) {
		// TODO Auto-generated method stub
		System.out.println("topic_send : " + msg);
		this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg);
	}

}
