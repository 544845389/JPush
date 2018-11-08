package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.api.service.WxPublicTemplateService;
import com.codingapi.push.server.dao.WxApplicationRepository;
import com.codingapi.push.server.entity.WxApplication;
import com.codingapi.push.server.service.WxPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/8
 * @company codingApi
 * @description
 */
@Service
public class WxPublicTemplateServiceImpl implements WxPublicTemplateService {


    @Autowired
    private WxPush wxPush;


    /**
     * 获取模板列表
     * @param wxApplicationId
     * @return
     */
    @Override
    public List<Map<String,String>> getWxTemplateList(int wxApplicationId) {
        List<Map<String,String>> list =  wxPush.getWxTemplateList(wxApplicationId);
        return list;
    }


    /**
     * 删除模板
     * @param wxApplicationId
     * @return
     */
    @Override
    public int deleteWxTemplateById(int wxApplicationId , String templateId) {
        return wxPush.deleteWxTemplateById(wxApplicationId , templateId);
    }


}
