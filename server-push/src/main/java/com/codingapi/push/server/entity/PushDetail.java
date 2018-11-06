package com.codingapi.push.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  推送详情
 */
@Document(indexName="coding_api_push_detail",type="detail")
public class PushDetail {

    @Id
    private String id;


    /**
     * 应用id
     */
    private int  applicationId;


    /**
     * 推送状态 1：正常 ， 0失败
     */
    private  int  state;

    /**
     * 推送数据
     */
    private  String  data;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
