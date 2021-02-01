package com.baihuionline.usercenter.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Data
@Configuration
public class NacosConfig {

    @Value("${username}")
    private String name;
}
