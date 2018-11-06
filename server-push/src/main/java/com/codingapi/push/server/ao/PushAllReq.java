package com.codingapi.push.server.ao;


public class PushAllReq {

    private  String content;


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

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
