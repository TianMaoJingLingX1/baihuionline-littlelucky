package com.baihuionline.usercenter.chat.controller;

import com.baihuionline.usercenter.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/client")
public class NettyClientController {

    @Autowired
    private NacosConfig config;

    @GetMapping("/sendMsg/{msg}")
    public String sendMsg(@PathVariable String msg) {
        System.out.println(config.getName());
        return "收到消息" + msg;
    }
}
