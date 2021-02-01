package com.baihuionline.msgcenter.msg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-center")
public interface UserCenterClient {

    @GetMapping("/sendMsg/{msg}")
    public String sendMsg(@PathVariable String msg);
}
