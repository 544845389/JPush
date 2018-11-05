package com.codingapi.push.server.service.impl;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.codingapi.push.server.config.JPushConfig;
import com.codingapi.push.server.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PushServiceImpl implements PushService {


    @Autowired
    private JPushConfig  jPushConfig;


    private Logger logger = LoggerFactory.getLogger(PushServiceImpl.class);


    @Override
    public int sendAll(String content) {
        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build())
                .setMessage(Message.content(content))
                .build();
        return send(pushPayload);
    }



    @Override
    public int sendPushTag(String content, String tag) {
        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build())
                .setMessage(Message.content(content))
                .build();
        return send(pushPayload);
    }

    @Override
    public int sendPushMapTag(String content, String tag, Map<String, String> map) {
        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(content)
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder().addExtras(map).build())
                                .addPlatformNotification(
                                        IosNotification.newBuilder().addExtras(map).build())
                                .build())
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build())
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .build();
        return send(pushPayload);
    }

    @Override
    public int sendPushMapTagThrough(String content, String tag, Map<String, String> map) {
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build()).build();
        return send(pushPayload);
    }


    @Override
    public int sendPushAlias(String content, String alias) {
        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build())
                .setMessage(Message.content(content))
                .build();
        return send(pushPayload);
    }

    @Override
    public int sendPushMapAlias(String content, String alias , Map<String,String> map) {
        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(
                        Notification.newBuilder()
                                .setAlert(content)
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder().addExtras(map).build())
                                .addPlatformNotification(
                                        IosNotification.newBuilder().addExtras(map).build())
                                .build())
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build())
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .build();
        return send(pushPayload);
    }



    @Override
    public int sendPushMapAliasThrough(String content, String alias, Map<String, String> map) {
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .setOptions(Options.newBuilder().setApnsProduction(jPushConfig.getEnvironment().equals("0")).build()).build();
        return send(pushPayload);
    }


    private int send(PushPayload payload)  {
        try {
            JPushClient jpushClient = new JPushClient(jPushConfig.getSecret() , jPushConfig.getKey());
            PushResult result = jpushClient.sendPush(payload);
            if (result.getResponseCode() == 200) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }





}
