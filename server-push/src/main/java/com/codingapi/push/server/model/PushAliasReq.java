package com.codingapi.push.server.model;

import java.util.Map;

public class PushAliasReq {

    private  String content;


    private  String alias;


    /**
     * 推送方式  极光/其他。。。
     */
    private  String way;

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
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
