package com.codingapi.push.server.entity;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public enum Setting {


    /**
     * 1:开发环境 0:生产环境
     */
    极光_推送环境("jPush_environment");

    private String state;

    Setting(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return String.valueOf(this.state);
    }
}
