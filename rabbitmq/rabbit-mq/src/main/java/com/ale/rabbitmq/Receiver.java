package com.ale.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "ale's queue")
    public void receive(String msg){
        System.out.println("Receiver" + msg);
    }
}
