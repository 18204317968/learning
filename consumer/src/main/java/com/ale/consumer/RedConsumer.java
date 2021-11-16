package com.ale.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.red}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange2}", type = ExchangeTypes.FANOUT)))
public class RedConsumer {
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("收到广播消息，发红包 " + msg + " ---");
    }
}
