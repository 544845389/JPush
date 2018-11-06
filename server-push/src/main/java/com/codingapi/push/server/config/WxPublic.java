package com.codingapi.push.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Component
@ConfigurationProperties(prefix = "wx.public")
public class WxPublic {

    private  String appid;

    private  String appsecret;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}
