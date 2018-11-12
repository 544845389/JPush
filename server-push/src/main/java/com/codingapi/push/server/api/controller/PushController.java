package com.codingapi.push.server.api.controller;

import com.codingapi.push.server.api.service.PushService;
import com.codingapi.push.server.ao.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  推送 api
 */
@Api(description = "推送 Api")
@RestController
@RequestMapping("push")
public class PushController {


    @Autowired
    private PushService pushService;


    @PostMapping("/sendAll")
    public  int sendAll(@RequestBody PushAllReq pushAllReq){
        return pushService.sendAll(pushAllReq);
    }


    @PostMapping("/sendPushTag")
    public  int sendPushTag(@RequestBody PushTagReq pushTagReq){
        return pushService.sendPushTag(pushTagReq);
    }


    @PostMapping("/sendPushMapTag")
    public  int sendPushMapTag(@RequestBody PushTagMapReq pushTagMapReq){
        return pushService.sendPushMapTag(pushTagMapReq);
    }




    @PostMapping("/sendPushMapTagThrough")
    public  int sendPushMapTagThrough(@RequestBody PushTagThroughReq pushTagThroughReq){
        return pushService.sendPushMapTagThrough(pushTagThroughReq);
    }



    @PostMapping("/sendPushAlias")
    public  int sendPushAlias(@RequestBody PushAliasReq pushAliasReq){
        return pushService.sendPushAlias(pushAliasReq);
    }


    @PostMapping("/sendPushMapAlias")
    public  int sendPushMapAlias(@RequestBody PushAliasMapReq pushAliasMapReq){
        return pushService.sendPushMapAlias(pushAliasMapReq);
    }


    @PostMapping("/sendPushMapAliasThrough")
    public  int sendPushMapAliasThrough(@RequestBody PushAliasMapThroughReq pushAliasMapTHroughReq){
        return pushService.sendPushMapAliasThrough(pushAliasMapTHroughReq);
    }




}
