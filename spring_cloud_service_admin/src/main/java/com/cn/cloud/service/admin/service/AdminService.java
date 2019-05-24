package com.cn.cloud.service.admin.service;

import com.cn.cloud.service.admin.domain.TbSysUser;

/**
 * 管理员服务
 */
public interface AdminService {
    /**
     * 注册
     * @param tbSysUser 管理员实体
     */
    void register(TbSysUser tbSysUser);

    /**
     * 登录
     * @param loginCode 登录账号
     * @param plantPssWord  明文密码
     * @return  TbSysUser管理员实体
     */
    TbSysUser login(String loginCode,String plantPssWord);
}
