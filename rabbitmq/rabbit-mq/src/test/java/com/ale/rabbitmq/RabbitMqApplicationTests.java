package com.ale.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
class RabbitMqApplicationTests {
    @Autowired
    private Sender sender;
    @Test
    void contextLoads() {
    }

    @Test
    public void send(){
        this.sender.send();
    }

}
