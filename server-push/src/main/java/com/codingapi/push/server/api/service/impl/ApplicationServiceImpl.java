package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.api.service.ApplicationService;
import com.codingapi.push.server.dao.ApplicationRepository;
import com.codingapi.push.server.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {



    @Autowired
    private ApplicationRepository  applicationRepository;

    @Override
    public int saveApplication(int id ,String name, String key, String secret , String type) {
        Application  application = new Application();
        application.setId(id);
        application.setName(name);
        application.setKey(key);
        application.setSecret(secret);
        application.setType(type);

        Application  sApplication =  applicationRepository.index(application);
        return  sApplication == null ? 0 : 1;
    }


}
