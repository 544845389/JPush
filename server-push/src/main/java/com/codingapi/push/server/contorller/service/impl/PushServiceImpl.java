package com.codingapi.push.server.contorller.service.impl;

import com.codingapi.push.server.contorller.service.PushService;
import com.codingapi.push.server.factory.PushFactory;
import com.codingapi.push.server.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PushServiceImpl implements PushService {



    @Override
    public int sendAll(@RequestBody PushAllReq pushAllReq) {
        return PushFactory.createPush(pushAllReq.getPlatform()).sendAll(pushAllReq.getContent());
    }

    @Override
    public int sendPushTag(PushTagReq pushTagReq) {
        return 0;
    }

    @Override
    public int sendPushMapTag(PushTagMapReq pushTagMapReq) {
        return 0;
    }

    @Override
    public int sendPushMapTagThrough(PushTagThroughReq pushTagThroughReq) {
        return 0;
    }

    @Override
    public int sendPushAlias(PushAliasReq pushAliasReq) {
        return 0;
    }

    @Override
    public int sendPushMapAlias(PushAliasMapReq pushAliasMapReq) {
        return 0;
    }

    @Override
    public int sendPushMapAliasThrough(PushAliasMapTHroughReq pushAliasMapTHroughReq) {
        return 0;
    }
}
