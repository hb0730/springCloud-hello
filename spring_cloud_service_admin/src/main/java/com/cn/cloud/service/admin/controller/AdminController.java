package com.cn.cloud.service.admin.controller;

import com.cn.cloud.common.dto.BaseResult;
import com.cn.cloud.service.admin.domain.TbSysUser;
import com.cn.cloud.service.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
* @className: AdminController
* @description: //TODO  管理员用户服务提供者
* @author: bing_huang
* @create: 2019/5/24 12:27
**/
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * @Author bing_huang
     * @Description //TODO 登录
     * @Date 12:27 2019/5/24
     * @param: loginCode 用户账户
     * @param: passWord 用户密码
     * @return com.cn.cloud.common.dto.BaseResult
     **/
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public BaseResult login(String loginCode,String passWord){
        BaseResult baseResult = checkLogin(loginCode
                , passWord);
        if(!org.springframework.util.StringUtils.isEmpty(baseResult)){
            return baseResult;
        }

        TbSysUser login = adminService.login(loginCode, passWord);

        if(org.springframework.util.StringUtils.isEmpty(login)){
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("", "登录失败")));
        }else{
            return BaseResult.ok(login);
        }
    }
    /**
     * @Author bing_huang
     * @Description //TODO 登录检查
     * @Date 12:29 2019/5/24
     * @param: loginCode 用户账户
     * @param: passWord 用户密码
     * @return com.cn.cloud.common.dto.BaseResult
     **/
    public BaseResult checkLogin(String loginCode,String passWord){
       BaseResult baseResult=null;
//        List<BaseResult.Error> errors= Lists.newArrayList();
//        if(StringUtils.isBlank(loginCode)){
//            BaseResult.Error error=new BaseResult.Error("loginCode", "loginCode is null");
//            errors.add(error);
//        }
//        if(StringUtils.isBlank(passWord)){
//            BaseResult.Error error=new BaseResult.Error("passWord", "passWord is null");
//            errors.add(error);
//        }
        if(StringUtils.isBlank(loginCode)||StringUtils.isBlank(passWord)){
            ArrayList<BaseResult.Error> errors = Lists.newArrayList(
                    new BaseResult.Error("loginCode", "loginCode is Null"),
                    new BaseResult.Error("PassWord", "PassWord is Null")
            );
            baseResult=BaseResult.notOk(errors);

        }
       return baseResult;
    }
}
