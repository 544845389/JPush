package com.codingapi.push.server.api.service.impl;

import com.codingapi.push.server.ao.PushWxMsgByReq;
import com.codingapi.push.server.ao.PushWxMsgMassReq;
import com.codingapi.push.server.api.service.WxPublicPushService;
import com.codingapi.push.server.service.WxPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 侯存路
 * @date 2018/11/8
 * @company codingApi
 * @description
 */
@Service
public class WxPublicPushServiceImpl implements WxPublicPushService {


    @Autowired
    private WxPush wxPush;


    @Override
    public int pushWxMsgByOpenId(PushWxMsgByReq pushWxMsgByReq) {
        return wxPush.pushWxMsgByOpenId(pushWxMsgByReq);
    }



    @Override
    public int pushWxMsgByMass(PushWxMsgMassReq pushWxMsgMassReq) {
        return wxPush.pushWxMsgByMass(pushWxMsgMassReq);
    }


}
