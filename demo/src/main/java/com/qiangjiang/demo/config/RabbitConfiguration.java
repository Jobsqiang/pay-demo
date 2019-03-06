package com.qiangjiang.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue userQueue(AmqpAdmin amqpAdmin){
        String queueName = "dev_user_queue";
        Queue queue = new Queue(queueName,true);
        amqpAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    public DirectExchange userExchange(AmqpAdmin amqpAdmin){
        String exchangeName = "dev_user_exchange";
        DirectExchange exchange = new DirectExchange(exchangeName);
//        exchange.setDelayed(true);
        amqpAdmin.declareExchange(exchange);
        return exchange;
    }

    @Bean
    public Binding userBinding(AmqpAdmin amqpAdmin){
        return BindingBuilder.bind(userQueue(amqpAdmin)).to(userExchange(amqpAdmin)).with("dev_user_key");
    }
}
