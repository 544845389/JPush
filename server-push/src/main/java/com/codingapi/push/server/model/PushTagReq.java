package com.codingapi.push.server.model;


public class PushTagReq {

    private  String content;


    private  String tag;


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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
