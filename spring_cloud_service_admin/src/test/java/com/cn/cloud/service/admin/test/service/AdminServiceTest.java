package com.cn.cloud.service.admin.test.service;

import com.cn.cloud.service.admin.ServiceAdminApplication;
import com.cn.cloud.service.admin.domain.TbSysUser;
import com.cn.cloud.service.admin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@Transactional
@Rollback
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    @Test
    public void register(){
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("1278032416@qq.com");
        tbSysUser.setUserName("bing_huang");
        tbSysUser.setUserType("1");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("iToken");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        adminService.register(tbSysUser);
    }
    @Test
    public void login(){
        TbSysUser tbSysUser = adminService.login("1278032416@qq.com", "123456");
        Assert.assertNotNull(tbSysUser);
    }
}
