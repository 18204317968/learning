package com.ale.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/error")
public class ErrorController {
    @PostMapping("error1")
    public String error1() {
        int i = 9 / 0;
        return "success";
    }
}
