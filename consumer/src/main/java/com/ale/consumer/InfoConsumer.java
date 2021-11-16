package com.ale.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.TOPIC), key = "*.log.info"))
public class InfoConsumer {
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("info-log = " + msg + " ---");
    }
}
