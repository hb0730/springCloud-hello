package com.cn.cloud.service.admin.service.impl;

import com.cn.cloud.service.admin.domain.TbSysUser;
import com.cn.cloud.service.admin.mapper.TbSysUserMapper;
import com.cn.cloud.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 实现 AdminService
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl  implements AdminService {
    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    @Transactional(readOnly = false)
    public void register(TbSysUser tbSysUser) {
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String plantPssWord) {
        Example example=new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",loginCode);
        TbSysUser tbSysUser = tbSysUserMapper.selectOneByExample(example);
        if(!StringUtils.isEmpty(plantPssWord)){
            String passWord = DigestUtils.md5DigestAsHex(plantPssWord.getBytes());
            if(passWord.equals(tbSysUser.getPassword())){
                return tbSysUser;
            }else {
                return null;
            }
        }else{
            return null;
        }

    }
}
