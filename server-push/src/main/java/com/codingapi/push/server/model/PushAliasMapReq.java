package com.codingapi.push.server.model;

import java.util.Map;

public class PushAliasMapReq {

    private  String content;


    private  String alias;


    private Map<String,String> map;


    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
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
