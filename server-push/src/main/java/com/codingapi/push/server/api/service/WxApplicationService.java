package com.codingapi.push.server.api.service;

import com.codingapi.push.server.entity.WxApplication;
import org.springframework.data.domain.Page;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface WxApplicationService {


    /**
     * 保存 微信公众号应用
     * @param id
     * @param name
     * @param appId
     * @param secret
     * @return
     */
    int saveOrWxApplication(int id, String name, String appId, String secret);


    /**
     * 删除
     * @param id
     * @return
     */
    int deleteWxApplication(int id);


    /**
     * 查询 所有微信应用
     * @return
     */
    Page<WxApplication> findWxApplicationList();
}
