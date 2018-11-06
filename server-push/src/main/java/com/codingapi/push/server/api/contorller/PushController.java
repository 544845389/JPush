package com.codingapi.push.server.api.contorller;

import com.alibaba.fastjson.JSON;
import com.codingapi.push.server.api.service.PushService;
import com.codingapi.push.server.ao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  推送 api
 */
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


    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","名字");
        map.put("value","值");

        PushTagMapReq pushTagMapReq = new PushTagMapReq();
        pushTagMapReq.setApplicationId(1);
        pushTagMapReq.setContent("123");
        pushTagMapReq.setMap(map);
        pushTagMapReq.setTag("tag");
        System.out.println("JSON = " + JSON.toJSONString(pushTagMapReq));
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
