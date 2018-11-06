package com.codingapi.push.server.api.service;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface ApplicationService {


    /**
     * 保存应用信息
     * @param name
     * @param key
     * @param secret
     * @return
     */
    int saveApplication(int id ,String name, String key, String secret , String type);
}
