package com.codingapi.push.server.api.service;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface WxApplicationService {


    /**
     * 保存 微信公众号应用
     * @param id
     * @param name
     * @param appId
     * @param secret
     * @return
     */
    int saveWxApplication(int id, String name, String appId, String secret);
}
