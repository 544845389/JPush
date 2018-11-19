package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.ao.GetApplicationTypeListRes;
import com.codingapi.push.server.api.service.ApplicationService;
import com.codingapi.push.server.dao.ApplicationRepository;
import com.codingapi.push.server.dao.ApplicationSettingRepository;
import com.codingapi.push.server.entity.Application;
import com.codingapi.push.server.entity.ApplicationSetting;
import com.codingapi.push.server.entity.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    @Autowired
    private ApplicationSettingRepository applicationSettingRepository;


    @Override
    public int saveApplication(int id ,String name, String key, String secret , String type){
        Application  application = new Application();
        int count  =  applicationRepository.findAll(PageRequest.of(0 , 1000)).getNumberOfElements();
        if(id == 0){
            application.setId(count+1);
        }else{
            application.setId(id);
        }
        application.setName(name);
        application.setKey(key);
        application.setSecret(secret);
        application.setType(type);

        Application  sApplication =  applicationRepository.index(application);
        return  sApplication == null ? 0 : 1;
    }



    @Override
    public List<GetApplicationTypeListRes> getApplicationTypeList() {
        // todo 增加应用类型
        GetApplicationTypeListRes getApplicationTypeListRes = new GetApplicationTypeListRes();
        getApplicationTypeListRes.setName("jPush");

        List<GetApplicationTypeListRes> list = new ArrayList<>();
        list.add(getApplicationTypeListRes);
        return list;
    }




    @Override
    public int deleteApplication(int id) {
        applicationRepository.deleteById(id);
        return 1 ;
    }


    @Override
    public Page<Application>  findList(int nowPage, int pageSize) {
        Page<Application>  page = applicationRepository.findAll(PageRequest.of(nowPage , pageSize));
        return page;
    }



    @Override
    public int saveApplicationSetting(int applicationId) {
        List<ApplicationSetting> list = new ArrayList<>();

        ApplicationSetting  applicationSetting = new  ApplicationSetting();
        applicationSetting.setId(getId(applicationId,1));
        applicationSetting.setApplicationId(applicationId);
        applicationSetting.setValue("1");
        applicationSetting.setParameter(Setting.极光_推送环境.toString());
        applicationSetting.setInfo("极光推送开发/生产环境配置");
        list.add(applicationSetting);

        // todo 后续增加新的配置

        applicationSettingRepository.saveAll(list);
        return 0;
    }



    private int  getId(int id , int index){
        String newId = id+"0"+index;
        return  Integer.parseInt(newId);
    }



}
