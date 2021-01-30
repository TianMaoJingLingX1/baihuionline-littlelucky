package com.baihuionline.usercenter.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/client")
public class NettyClientController {

    @GetMapping("/sendMsg/{msg}")
    public String sendMsg(@PathVariable String msg) {
        return "收到消息" + msg;
    }
}
