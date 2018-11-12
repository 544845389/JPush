package com.codingapi.push.server.api.controller.wxpublic;

import com.codingapi.push.server.ao.PushWxMsgByReq;
import com.codingapi.push.server.ao.PushWxMsgMassReq;
import com.codingapi.push.server.api.service.WxPublicPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  微信公众平台推送消息
 */
@RestController
@RequestMapping("/wxPublicPush")
public class WxPublicPushController {


    @Autowired
    private WxPublicPushService  wxPublicPushService;



    /**
     * 推送单个消息 模板
     * @param
     * @return
     */
    @PostMapping("/pushWxMsgByOpenId")
    public int pushWxMsgByOpenId(@RequestBody PushWxMsgByReq pushWxMsgByReq){
        return wxPublicPushService.pushWxMsgByOpenId(pushWxMsgByReq);
    }



    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     * @param
     * @return
     */
    @PostMapping("/pushWxMsgByMass")
    public int pushWxMsgByMass(@RequestBody PushWxMsgMassReq pushWxMsgMassReq){
        return wxPublicPushService.pushWxMsgByMass(pushWxMsgMassReq);
    }




}
