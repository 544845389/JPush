package com.codingapi.push.server.service;

import com.codingapi.push.server.entity.Application;

import java.util.Map;

public interface Push {



    /**
     * 推送全部
     * @param content
     * @return
     */
    int sendAll(String content , Application application);



    /**
     * 标签推送
     * @param content
     * @return
     */
    int sendPushTag(String content, String tag ,  Application application);


    /**
     * 标签推送
     * @param content
     * @return
     */
    int sendPushMapTag(String content, String tag, Map<String, String> map ,  Application application);


    /**
     * 标签透传
     * @param content
     * @return
     */
    int sendPushMapTagThrough(String content, String tag, Map<String, String> map , Application application);




    /**
     * 别名推送
     *
     * @param content
     * @param alias
     * @return
     */
    int sendPushAlias(String content, String alias ,  Application application);


    /**
     * 别名推送
     * @param content
     * @param alias
     * @return
     */
    int sendPushMapAlias(String content, String alias, Map<String, String> map ,  Application application);


    /**
     * 别名透传
     * @param content
     * @return
     */
    int sendPushMapAliasThrough(String content, String alias, Map<String, String> map ,  Application application);


}
