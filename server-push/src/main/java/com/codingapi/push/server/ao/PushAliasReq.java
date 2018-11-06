package com.codingapi.push.server.ao;

public class PushAliasReq {

    private  String content;


    private  String alias;


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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
