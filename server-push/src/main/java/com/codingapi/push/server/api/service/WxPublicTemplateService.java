package com.codingapi.push.server.api.service;

import java.util.List;
import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/8
 * @company codingApi
 * @description
 */
public interface WxPublicTemplateService {


    /**
     * 获取 微信模板列表
     * @param wxApplicationId
     * @return
     */
    List<Map<String,String>> getWxTemplateList(int wxApplicationId);


    /**
     * 删除模板
     * @param wxApplicationId
     * @return
     */
    int deleteWxTemplateById(int wxApplicationId , String templateId);
}
