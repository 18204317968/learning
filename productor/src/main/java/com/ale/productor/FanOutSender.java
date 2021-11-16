package com.ale.productor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FanOutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchanger;

    public void send() {
        String msg = "广播消息：11111  " + new Date();
        this.rabbitTemplate.convertAndSend(exchanger, "", "fanout1---" + msg);
        this.rabbitTemplate.convertAndSend(exchanger, "", "fanout2---" + msg);
        this.rabbitTemplate.convertAndSend(exchanger, "", "fanout3---" + msg);
        this.rabbitTemplate.convertAndSend(exchanger, "", "fanout4---" + msg);
    }
}
