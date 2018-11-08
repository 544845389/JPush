package com.codingapi.push.server.ao;

import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/8
 * @company codingApi
 * @description
 */
public class PushWxMsgByReq {


    private int applicationId;


    private String openId;


    private String templateId;


    private Map<String,Object> mapData;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<String, Object> getMapData() {
        return mapData;
    }

    public void setMapData(Map<String, Object> mapData) {
        this.mapData = mapData;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
