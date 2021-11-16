package com.ale.productor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchanger;

    public void send() {
        String msg = "hello:::" + new Date();
        this.rabbitTemplate.convertAndSend(exchanger,"log.error.routing.key", msg);
    }
}
