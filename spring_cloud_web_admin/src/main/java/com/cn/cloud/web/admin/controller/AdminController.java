package com.cn.cloud.web.admin.controller;

import com.cn.cloud.web.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @className: AdminController
 * @description: //TODO web -admin Controller
 * @author: bing_huang
 * @create: 2019/5/24 14:21
 **/
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public  String login(){
        String login = adminService.login("", "");
        System.out.println(login);
        return "index";
    }
}
