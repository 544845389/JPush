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
import com.codingapi.push.server.dao.ApplicationSettingRepository;
import com.codingapi.push.server.dao.PushDetailRepository;
import com.codingapi.push.server.entity.Application;
import com.codingapi.push.server.entity.PushDetail;
import com.codingapi.push.server.entity.Setting;
import com.codingapi.push.server.service.Push;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service("jPush")
public class JPush implements Push {


    private Logger logger = LoggerFactory.getLogger(JPush.class);


    @Autowired
    private ApplicationSettingRepository applicationSettingRepository;


    @Autowired
    private PushDetailRepository pushDetailRepository;


    @Override
    public int sendAll(String content ,  Application application) {

        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build())
                .setMessage(Message.content(content))
                .build();
        return send(pushPayload , application);
    }



    @Override
    public int sendPushTag(String content, String tag ,   Application application) {
        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build())
                .setMessage(Message.content(content))
                .build();
        return send(pushPayload , application);
    }

    @Override
    public int sendPushMapTag(String content, String tag, Map<String, String> map ,  Application application) {
        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

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
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build())
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .build();
        return send(pushPayload , application);
    }

    @Override
    public int sendPushMapTagThrough(String content, String tag, Map<String, String> map , Application application) {
        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tag))
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build()).build();
        return send(pushPayload , application);
    }


    @Override
    public int sendPushAlias(String content, String alias , Application application) {
        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

        PushPayload pushPayload =  PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(content))
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build())
                .setMessage(Message.content(content))
                .build();
        return send(pushPayload , application);
    }

    @Override
    public int sendPushMapAlias(String content, String alias , Map<String,String> map , Application application) {
        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

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
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build())
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .build();
        return send(pushPayload , application);
    }



    @Override
    public int sendPushMapAliasThrough(String content, String alias, Map<String, String> map , Application application) {
        String environment = applicationSettingRepository.findByApplicationIdAndParameter(application.getId() , Setting.极光_推送环境.toString()).getValue();

        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder().setMsgContent(content).addExtras(map).build())
                .setOptions(Options.newBuilder().setApnsProduction(environment.equals("0")).build()).build();
        return send(pushPayload , application);
    }


    private int send(PushPayload payload , Application application)  {
        int state = 0;
        PushDetail pushDetail = new PushDetail();
        pushDetail.setApplicationId(application.getId());
        pushDetail.setId(UUID.randomUUID().toString());

        try {
            JPushClient jpushClient = new JPushClient(application.getSecret() , application.getKey());
            PushResult result = jpushClient.sendPush(payload);
            if (result.getResponseCode() == 200) {
                state = 1;
            }
        } catch (Exception e) {
            logger.error("应用Id:"+application.getId()+"/推送错误:"+e.getMessage());
            state = 0;
        }

        String str =  payload.toJSON().toString();

        pushDetail.setState(state);
        pushDetail.setData(str);
        pushDetailRepository.index(pushDetail);
        return state;
    }





}
