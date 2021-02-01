package com.baihuionline.msgcenter.msg.controller;

import com.baihuionline.msgcenter.msg.service.UserCenterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    UserCenterClient userCenterClient;

    @GetMapping("/send")
    public String sendMsg() {
        return userCenterClient.sendMsg("我是客户端呀");
    }
}
