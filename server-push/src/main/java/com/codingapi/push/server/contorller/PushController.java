package com.codingapi.push.server.contorller;

import com.codingapi.push.server.model.*;
import com.codingapi.push.server.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("push")
public class PushController {


    @Autowired
    private PushService jPushService;


    @GetMapping("/sendAll")
    public  int sendAll(@RequestParam("content") String content){
        return jPushService.sendAll(content);
    }


    @PostMapping("/sendPushTag")
    public  int sendPushTag(@RequestBody PushTagReq pushTagReq){
        return jPushService.sendPushTag(pushTagReq.getContent() , pushTagReq.getTag());
    }


    @PostMapping("/sendPushMapTag")
    public  int sendPushMapTag(@RequestBody PushTagMapReq pushTagMapReq){
        return jPushService.sendPushMapTag(pushTagMapReq.getContent() , pushTagMapReq.getTag() , pushTagMapReq.getMap());
    }


    @PostMapping("/sendPushMapTagThrough")
    public  int sendPushMapTagThrough(@RequestBody PushTagThroughReq pushTagThroughReq){
        return jPushService.sendPushMapTagThrough(pushTagThroughReq.getContent() , pushTagThroughReq.getTag() , pushTagThroughReq.getMap());
    }



    @PostMapping("/sendPushAlias")
    public  int sendPushAlias(@RequestBody PushAliasReq pushAliasReq){
        return jPushService.sendPushAlias(pushAliasReq.getContent() , pushAliasReq.getAlias());
    }


    @PostMapping("/sendPushMapAlias")
    public  int sendPushMapAlias(@RequestBody PushAliasMapReq pushAliasMapReq){
        return jPushService.sendPushMapAlias(pushAliasMapReq.getContent() , pushAliasMapReq.getAlias(), pushAliasMapReq.getMap());
    }


    @PostMapping("/sendPushMapAliasThrough")
    public  int sendPushMapAliasThrough(@RequestBody PushAliasMapTHroughReq pushAliasMapTHroughReq){
        return jPushService.sendPushMapAliasThrough(pushAliasMapTHroughReq.getContent() , pushAliasMapTHroughReq.getAlias(), pushAliasMapTHroughReq.getMap());
    }







}
