package com.ale.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.push}", autoDelete = "true"), exchange = @Exchange(value = "${mq.config.exchange2}", type = ExchangeTypes.FANOUT)))
public class PushConsumer {
    private int num;

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("收到广播消息，推送消息 " + msg + " ---");
        throw new RuntimeException("抛出异常" + ++num);
    }
}
