package com.codingapi.push.server.ao;


public class PushTagReq {

    private  String content;


    private  String tag;


    /**
     * 应用id
     */
    private  int applicationId;


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

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
