package com.example.demo.consumer.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {
   //先启动生产者
   /* @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }*/

}