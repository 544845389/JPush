package com.codingapi.push.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description     应用列表
 */
@Document(indexName="coding_api_push_application",type="application")
public class Application {


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
     * 应用推送平台
     */
    private  String  type;


    /**
     * 应用 key
     */
    private  String  key;

    /**
     * 应用 密钥
     */
    private  String  secret;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
