package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.api.service.WxApplicationService;
import com.codingapi.push.server.dao.WxApplicationRepository;
import com.codingapi.push.server.entity.WxApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Service
public class WxApplicationServiceImpl implements WxApplicationService {


    @Autowired
    private WxApplicationRepository wxApplicationRepository;


    @Override
    public int saveOrWxApplication(int id, String name, String appId, String secret) {
        WxApplication  wxApplication = new WxApplication();
        wxApplication.setId(id);
        wxApplication.setAppId(appId);
        wxApplication.setName(name);
        wxApplication.setSecret(secret);
        WxApplication save =  wxApplicationRepository.save(wxApplication);
        return save == null ? 0 : 1;
    }



    @Override
    public int deleteWxApplication(int id) {
        wxApplicationRepository.deleteById(id);
        return 1;
    }


}
