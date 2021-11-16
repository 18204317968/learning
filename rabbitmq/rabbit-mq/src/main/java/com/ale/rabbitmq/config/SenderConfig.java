package com.ale.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {
    @Bean
    public Queue getQueue(){
        return new Queue("ale's queue");
    }
}
