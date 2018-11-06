package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.api.service.ApplicationService;
import com.codingapi.push.server.api.service.ApplicationSettingService;
import com.codingapi.push.server.api.service.PushService;
import com.codingapi.push.server.dao.ApplicationRepository;
import com.codingapi.push.server.entity.Application;
import com.codingapi.push.server.factory.PushFactory;
import com.codingapi.push.server.ao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class PushServiceImpl implements PushService {



    @Autowired
    private ApplicationRepository applicationRepository;



    @Override
    public int sendAll(@RequestBody PushAllReq pushAllReq) {
        Application application =  applicationRepository.findById(pushAllReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendAll(pushAllReq.getContent() , application );
    }


    @Override
    public int sendPushTag(PushTagReq pushTagReq) {
        Application application =  applicationRepository.findById(pushTagReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendPushTag(pushTagReq.getContent() ,pushTagReq.getTag() , application);
    }

    @Override
    public int sendPushMapTag(PushTagMapReq pushTagMapReq) {
        Application application =  applicationRepository.findById(pushTagMapReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendPushMapTag(pushTagMapReq.getContent() ,pushTagMapReq.getTag() , pushTagMapReq.getMap() , application);
    }

    @Override
    public int sendPushMapTagThrough(PushTagThroughReq pushTagThroughReq) {
        Application application =  applicationRepository.findById(pushTagThroughReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendPushMapTagThrough(pushTagThroughReq.getContent() ,pushTagThroughReq.getTag() , pushTagThroughReq.getMap() ,application);
    }

    @Override
    public int sendPushAlias(PushAliasReq pushAliasReq) {
        Application application =  applicationRepository.findById(pushAliasReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendPushAlias(pushAliasReq.getContent() ,pushAliasReq.getAlias() ,application);
    }

    @Override
    public int sendPushMapAlias(PushAliasMapReq pushAliasMapReq) {
        Application application =  applicationRepository.findById(pushAliasMapReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendPushMapAlias(pushAliasMapReq.getContent() ,pushAliasMapReq.getAlias() , pushAliasMapReq.getMap() ,application);
    }

    @Override
    public int sendPushMapAliasThrough(PushAliasMapThroughReq pushAliasMapTHroughReq) {
        Application application =  applicationRepository.findById(pushAliasMapTHroughReq.getApplicationId()).get();
        return PushFactory.createPush(application.getType()).sendPushMapAliasThrough(pushAliasMapTHroughReq.getContent() ,pushAliasMapTHroughReq.getAlias() , pushAliasMapTHroughReq.getMap() ,application);
    }



}
