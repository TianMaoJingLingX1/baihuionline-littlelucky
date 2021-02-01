package com.baihuionline.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
public class UsercenterApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(UsercenterApplication.class, args);
    }

}
