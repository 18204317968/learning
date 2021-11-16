package com.ale.productor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchanger;

    public void send() {
        String msg = "user:::" + new Date();
        this.rabbitTemplate.convertAndSend(exchanger, "user.log.debug", "debug---" + msg);
        this.rabbitTemplate.convertAndSend(exchanger, "user.log.info", "info---" + msg);
        this.rabbitTemplate.convertAndSend(exchanger, "user.log.warn", "warn---" + msg);
        this.rabbitTemplate.convertAndSend(exchanger, "user.log.error", "error---" + msg);
    }
}
