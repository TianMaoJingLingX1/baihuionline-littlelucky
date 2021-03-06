package com.baihuionline.msgcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.baihuionline.msgcenter.msg.service")
public class MsgcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgcenterApplication.class, args);
    }

}
