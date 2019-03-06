package com.qiangjiang.demo.service;

import com.google.gson.Gson;
import com.qiangjiang.demo.model.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void userMessage(User user){
        System.out.println("-------------发送消息开始--------------");
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        String userStr = new Gson().toJson(user);
        Message message = new Message(userStr.getBytes(),messageProperties);
        String exchange = "dev_user_exchange";
        String routeKey = "dev_user_key";
        rabbitTemplate.send(exchange, routeKey, message);
        System.out.println("-------------发送消息结束--------------");
    }


}
