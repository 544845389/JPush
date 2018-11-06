package com.codingapi.push.server.api.service;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface ApplicationSettingService {

    /**
     * 保存应用设置
     * @param id
     * @param applicationId
     * @param parameter
     * @param value
     * @return
     */
    int saveApplicationSetting(int id, int applicationId, String parameter, String value);
}
