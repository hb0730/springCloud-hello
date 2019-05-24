package com.cn.cloud.web.admin.service.fallback;

import com.cn.cloud.common.constants.HttpStatusConstants;
import com.cn.cloud.common.dto.BaseResult;
import com.cn.cloud.common.utils.MapperUtils;
import com.cn.cloud.web.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

/**
 * @className: AdminServiceFailBack
 * @description: //TODO 熔断
 * @author: bing_huang
 * @create: 2019/5/24 14:43
 **/
@Component
public class AdminServiceFallback implements AdminService {
    @Override
    public String login(String loginCode, String passWord) {
        BaseResult result = BaseResult.notOk(Lists.newArrayList(new BaseResult.Error(String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                HttpStatusConstants.BAD_GATEWAY.getContent())));
        try {
            String json = MapperUtils.obj2json(result);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
