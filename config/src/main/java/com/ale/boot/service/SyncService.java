package com.ale.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SyncService {
    @Async
    public void red() throws InterruptedException {
        Thread.sleep(10*1000);
        log.info("发十块钱红包");
    }

    @Async("scoreTaskPoolExecutor")
    public void sendMsg() throws InterruptedException {
        Thread.sleep(15*1000);
        log.info("发短信给用户通知注册成功");
    }
}
