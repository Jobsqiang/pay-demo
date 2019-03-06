package com.qiangjiang.demo.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserListener {

    @RabbitListener(containerFactory = "rabbitListenerContainerFactory" , queues = "dev_user_queue")
    public void userConsumer(Message message){
        System.out.println("---------消费开始----------");
        String s = new String(message.getBody());
        System.out.println("user consumer :"+s);
    }
}
