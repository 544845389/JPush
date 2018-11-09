package com.codingapi.push.server.api.service;

import com.codingapi.push.server.ao.GetApplicationTypeListRes;
import com.lorne.core.framework.exception.ServiceException;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
public interface ApplicationService {


    /**
     * 保存应用信息
     * @param name
     * @param key
     * @param secret
     * @return
     */
    int saveApplication(int id ,String name, String key, String secret , String type) throws ServiceException;


    /**
     * 获取应用类型
     * @return
     */
    List<GetApplicationTypeListRes> getApplicationTypeList();
}
