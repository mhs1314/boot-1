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
	public void queue_send(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Sender1 : " + msg);
		this.rabbitTemplate.convertAndSend("hello", msg);
	}

	@Override
	public void fanout_send(String msg) {
		// TODO Auto-generated method stub
		System.out.println("fanout_send : " + msg);
		this.rabbitTemplate.convertAndSend("fanoutExchange", "", msg);
	}

	@Override
	public void topic_send(String msg) {
		// TODO Auto-generated method stub
		System.out.println("topic_send : " + msg);
		this.rabbitTemplate.convertAndSend("exchange", "", msg);
	}

}
