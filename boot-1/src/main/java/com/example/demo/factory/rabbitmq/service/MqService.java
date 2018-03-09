package com.example.demo.factory.rabbitmq.service;

import java.util.Map;

/**
 * rabbitmq 发送服务
 * 
 * @author mhs123
 *
 */
public interface MqService {
	//Queue发送方式--平均分配给消费者
	public void queue_send(Map<String, Object> msg);

	// fanout发送方式--接收者均接收到信息。
	public void fanout_send(Map<String, Object> msg);

	// Topic发送方式接收到A接收到发送者A的信息。接收者Any接收到发送者A、发送者B、发送者Any的信息
	public void topic_send(Map<String, Object> msg);
}
