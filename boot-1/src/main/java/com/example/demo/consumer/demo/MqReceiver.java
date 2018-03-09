package com.example.demo.consumer.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {
	
	@RabbitListener(queues = "hello")
    public void queues_process_1(String hello) {
        System.out.println("queues_process_1  : " + hello);
    }
	
	@RabbitListener(queues = "hello")
    public void queues_process_2(String hello) {
        System.out.println("queues_process_2  : " + hello);
    }

}