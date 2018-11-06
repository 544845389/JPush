package com.codingapi.push.server.ao;

import java.util.Map;

public class PushTagThroughReq {

    private  String content;


    private  String tag;


    private Map<String,String> map;


    /**
     * 应用id
     */
    private  int applicationId;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
