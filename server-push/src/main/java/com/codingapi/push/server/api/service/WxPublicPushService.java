package com.codingapi.push.server.api.service;

import com.codingapi.push.server.ao.PushWxMsgByReq;
import com.codingapi.push.server.ao.PushWxMsgMassReq;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface WxPublicPushService {


    /**
     * 推送消息
     * @param pushWxMsgByReq
     * @return
     */
    int pushWxMsgByOpenId(PushWxMsgByReq pushWxMsgByReq);


    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     * @param
     * @return
     */
    int pushWxMsgByMass(PushWxMsgMassReq pushWxMsgMassReq);
}
