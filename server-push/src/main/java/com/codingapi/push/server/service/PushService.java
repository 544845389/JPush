package com.codingapi.push.server.service;

import java.util.Map;

public interface PushService {



    /**
     * 推送全部
     * @param content
     * @return
     */
    int sendAll(String content);



    /**
     * 标签推送
     * @param content
     * @return
     */
    int sendPushTag(String content , String tag);


    /**
     * 标签推送
     * @param content
     * @return
     */
    int sendPushMapTag(String content, String tag, Map<String, String> map);


    /**
     * 标签透传
     * @param content
     * @return
     */
    int sendPushMapTagThrough(String content, String tag, Map<String, String> map);




    /**
     * 别名推送
     *
     * @param content
     * @param alias
     * @return
     */
    int sendPushAlias(String content, String alias);


    /**
     * 别名推送
     * @param content
     * @param alias
     * @return
     */
    int sendPushMapAlias(String content, String alias ,  Map<String,String> map);


    /**
     * 别名透传
     * @param content
     * @return
     */
    int sendPushMapAliasThrough(String content, String alias, Map<String, String> map);


}
