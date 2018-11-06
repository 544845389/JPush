package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.api.service.PushService;
import com.codingapi.push.server.factory.PushFactory;
import com.codingapi.push.server.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PushServiceImpl implements PushService {





    @Override
    public int sendAll(@RequestBody PushAllReq pushAllReq) {
        return PushFactory.createPush(pushAllReq.getWay()).sendAll(pushAllReq.getContent());
    }

    @Override
    public int sendPushTag(PushTagReq pushTagReq) {
        return PushFactory.createPush(pushTagReq.getWay()).sendPushTag(pushTagReq.getContent() ,pushTagReq.getTag());
    }

    @Override
    public int sendPushMapTag(PushTagMapReq pushTagMapReq) {
        return PushFactory.createPush(pushTagMapReq.getWay()).sendPushMapTag(pushTagMapReq.getContent() ,pushTagMapReq.getTag() , pushTagMapReq.getMap());
    }

    @Override
    public int sendPushMapTagThrough(PushTagThroughReq pushTagThroughReq) {
        return PushFactory.createPush(pushTagThroughReq.getWay()).sendPushMapTagThrough(pushTagThroughReq.getContent() ,pushTagThroughReq.getTag() , pushTagThroughReq.getMap());
    }

    @Override
    public int sendPushAlias(PushAliasReq pushAliasReq) {
        return PushFactory.createPush(pushAliasReq.getWay()).sendPushAlias(pushAliasReq.getContent() ,pushAliasReq.getAlias());
    }

    @Override
    public int sendPushMapAlias(PushAliasMapReq pushAliasMapReq) {
        return PushFactory.createPush(pushAliasMapReq.getWay()).sendPushMapAlias(pushAliasMapReq.getContent() ,pushAliasMapReq.getAlias() , pushAliasMapReq.getMap());
    }

    @Override
    public int sendPushMapAliasThrough(PushAliasMapThroughReq pushAliasMapTHroughReq) {
        return PushFactory.createPush(pushAliasMapTHroughReq.getWay()).sendPushMapAliasThrough(pushAliasMapTHroughReq.getContent() ,pushAliasMapTHroughReq.getAlias() , pushAliasMapTHroughReq.getMap());
    }
}
