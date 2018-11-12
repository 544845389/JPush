package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.api.service.ApplicationSettingService;
import com.codingapi.push.server.dao.ApplicationSettingRepository;
import com.codingapi.push.server.entity.ApplicationSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Service
public class ApplicationSettingServiceImpl implements ApplicationSettingService {


    @Autowired
    private ApplicationSettingRepository applicationSettingRepository;


    @Override
    public int saveApplicationSetting(int id, int applicationId, String parameter, String value , String info) {
        ApplicationSetting applicationSetting = new ApplicationSetting();
        applicationSetting.setId(id);
        applicationSetting.setApplicationId(applicationId);
        applicationSetting.setParameter(parameter);
        applicationSetting.setValue(value);
        applicationSetting.setInfo(info);
        applicationSettingRepository.index(applicationSetting);
        return 1;
    }
}
