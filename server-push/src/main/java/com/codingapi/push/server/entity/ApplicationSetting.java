package com.codingapi.push.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description   应用设置
 */
@Document(indexName="coding_api_push_application_setting",type="application_setting")
public class ApplicationSetting {

    /**
     * id
     */
    @Id
    private  int id;

    /**
     * 应用id
     */
    private  int  applicationId;

    /**
     * 参数设置
     */
    private String  parameter;

    /**
     * 参数值
     */
    private String  value;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
