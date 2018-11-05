package com.codingapi.push.server.contorller;

import com.codingapi.push.server.contorller.service.PushService;
import com.codingapi.push.server.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public  int sendPushMapAliasThrough(@RequestBody PushAliasMapTHroughReq pushAliasMapTHroughReq){
        return pushService.sendPushMapAliasThrough(pushAliasMapTHroughReq);
    }







}
