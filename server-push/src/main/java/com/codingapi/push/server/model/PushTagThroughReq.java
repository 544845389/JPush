package com.codingapi.push.server.model;

import java.util.Map;

public class PushTagThroughReq {

    private  String content;


    private  String tag;


    private Map<String,String> map;

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
