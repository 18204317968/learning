package com.ale.productor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
class RabbitMqApplicationTests {
    @Autowired
    private Sender sender;

    @Autowired
    private UserSender userSender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;

    @Autowired
    private FanOutSender fanOutSender;

    @Test
    void contextLoads() {
    }

    @Test
    public void send() {
//        this.sender.send();
//        this.userSender.send();
//        this.productSender.send();
//        this.orderSender.send();
        this.fanOutSender.send();
    }

}
