package com.codingapi.push.server.model;


public class PushAllReq {

    private  String content;


    /**
     * 推送方式  极光/其他。。。
     */
    private  String way;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
