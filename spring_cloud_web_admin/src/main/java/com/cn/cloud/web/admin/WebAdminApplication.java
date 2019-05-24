package com.cn.cloud.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: WebAdminApplication
 * @description: //TODO admin 管理员用户 服务消费者
 * @author: bing_huang
 * @create: 2019/5/24 13:50
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }
}
