package com.example.demo.factory.rabbitmq.serviceImpl;

import java.util.Date;

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
	public void send(String msg) {
		// TODO Auto-generated method stub
		String sendMsg = "hello1 " + new Date();
		System.out.println("Sender1 : " + sendMsg);
		this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
	}

}
