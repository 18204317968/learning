package com.ale.boot.controller;

import com.ale.boot.service.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${ale.hello}")
    private String helloWorld;

    @Value("${ale.msg}")
    private String msg;

    @RequestMapping("/index")
    public String index() {
        return "here I am !!!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return helloWorld;
    }

    @RequestMapping("/msg")
    public String getMsg() {
        logger.info("I am getMag()!!!");
        return msg;
    }

    @RequestMapping("/log")
    public String getLog() {
        logger.info("I am info!!!");
        logger.trace("I am trace!!!");
        logger.debug("I am debug!!!");
        logger.error("I am error!!!");
        logger.warn("I am warn!!!");
        return "log";
    }

    @Autowired
    private SyncService service;

    @RequestMapping("createUser")
    public String createUser() throws InterruptedException {
        service.red();
        service.sendMsg();
        log.info("创建成功!!!");
        return "创建成功!!!";
    }
}
