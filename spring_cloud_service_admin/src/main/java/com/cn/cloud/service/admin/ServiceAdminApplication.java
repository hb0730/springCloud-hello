package com.cn.cloud.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 用户管理服务
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.cn.cloud.service.admin.mapper")
public class ServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class,args);
    }

}
