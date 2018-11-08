package com.codingapi.push.server.service;

import com.codingapi.push.server.ao.PushWxMsgByReq;
import com.codingapi.push.server.ao.PushWxMsgMassReq;

import java.util.List;
import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/7
 * @company codingApi
 * @description   微信公众号+
 */
public interface WxPush {


    /**
     * 获取 Token
     * @return
     */
    String   getAccessToken(int wxApplicationId);


    /**
     * 获取模板列表
     * @return
     */
    List<Map<String,String>>  getWxTemplateList(int wxApplicationId);


    /**
     * 删除模板
     * @param wxApplicationId
     * @return
     */
    int deleteWxTemplateById(int wxApplicationId , String templateId);


    /**
     * 向某个人 推送模板消息
     * @param pushWxMsgByReq
     * @return
     */
    int pushWxMsgByOpenId(PushWxMsgByReq pushWxMsgByReq);


    /**
     * 群发
     * @param pushWxMsgMassReq
     * @return
     */
    int pushWxMsgByMass(PushWxMsgMassReq pushWxMsgMassReq);


}
