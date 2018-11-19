package com.codingapi.push.server.api.service;

import com.codingapi.push.server.entity.ApplicationSetting;

import java.util.List;

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
    int saveApplicationSetting(int id, int applicationId, String parameter, String value , String info);


    /**
     * 调整 参数值
     * @param id
     * @param value
     * @return
     */
    int updateApplicationSetting(int id, String value);


    /**
     * 查询应用的 设置列表
     * @param id
     * @return
     */
    List<ApplicationSetting> findApplicationSettingByApplicationId(int id);
}
