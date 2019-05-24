package com.cn.cloud.web.admin.service;

import com.cn.cloud.web.admin.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @className: AdminService
 * @description: //TODO 服务消费者
 * @author: bing_huang
 * @create: 2019/5/24 14:39
 **/
@FeignClient(value = "spring-cloud-service-admin", fallback = AdminServiceFallback.class)
public interface AdminService {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(@RequestParam("loginCode")String loginCode,@RequestParam("passWord")String passWord);
}
