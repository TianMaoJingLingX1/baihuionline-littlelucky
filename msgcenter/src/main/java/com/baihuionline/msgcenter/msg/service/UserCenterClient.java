package com.baihuionline.msgcenter.msg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-center")
@RequestMapping("/chat/client")
public interface UserCenterClient {

    @GetMapping("/sendMsg/{msg}")
    String sendMsg(@PathVariable String msg);
}
