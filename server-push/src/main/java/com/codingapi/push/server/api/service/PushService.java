package com.codingapi.push.server.api.service;

import com.codingapi.push.server.model.*;
import org.springframework.web.bind.annotation.RequestBody;

public interface PushService {



    /**
     * 推送全部
     * @param
     * @return
     */
    int sendAll(@RequestBody PushAllReq pushAllReq);



    /**
     * 标签推送
     * @param
     * @return
     */
    int sendPushTag(PushTagReq pushTagReq);


    /**
     * 标签推送
     * @param
     * @return
     */
    int sendPushMapTag(PushTagMapReq pushTagMapReq);


    /**
     * 标签透传
     * @param
     * @return
     */
    int sendPushMapTagThrough(PushTagThroughReq pushTagThroughReq);




    /**
     * 别名推送
     *
     * @param
     * @param
     * @return
     */
    int sendPushAlias(PushAliasReq pushAliasReq);


    /**
     * 别名推送
     * @param
     * @param
     * @return
     */
    int sendPushMapAlias(PushAliasMapReq pushAliasMapReq);


    /**
     * 别名透传
     * @param
     * @return
     */
    int sendPushMapAliasThrough(PushAliasMapThroughReq pushAliasMapTHroughReq);




}
