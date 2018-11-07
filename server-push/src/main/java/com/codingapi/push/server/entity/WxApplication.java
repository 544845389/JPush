package com.codingapi.push.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 侯存路
 * @date 2018/11/7
 * @company codingApi
 * @description
 */
@Document(indexName="coding_api_push_wx_application",type="wx_application")
public class WxApplication {

    /**
     * 应用id
     */
    @Id
    private int id;

    /**
     * 应用名称
     */
    private  String  name;

    /**
     * 应用 appId
     */
    private  String  appId;

    /**
     * 应用 密钥
     */
    private  String  secret;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
