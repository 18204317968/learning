package com.ale.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.sms}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange2}", type = ExchangeTypes.FANOUT)))
public class SmsConsumer {
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("收到广播消息，发短信 " + msg + " ---");
    }
}
