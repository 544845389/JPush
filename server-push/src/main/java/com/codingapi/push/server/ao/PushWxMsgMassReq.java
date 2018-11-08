package com.codingapi.push.server.ao;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/8
 * @company codingApi
 * @description
 */
public class PushWxMsgMassReq {


    private int wxApplicationId;


    /**
     * 用户 openId  列表
     */
    private List<String> touser;


    /**
     * 内容
     */
    private String content;


    public List<String> getTouser() {
        return touser;
    }

    public void setTouser(List<String> touser) {
        this.touser = touser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWxApplicationId() {
        return wxApplicationId;
    }

    public void setWxApplicationId(int wxApplicationId) {
        this.wxApplicationId = wxApplicationId;
    }
}
