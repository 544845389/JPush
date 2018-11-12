package com.codingapi.push.server.api.service;

import com.codingapi.push.server.ao.GetApplicationTypeListRes;
import com.codingapi.push.server.entity.Application;
import com.lorne.core.framework.exception.ServiceException;
import org.springframework.data.domain.Page;

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
    int saveApplication(int id ,String name, String key, String secret , String type) ;


    /**
     * 获取应用类型
     * @return
     */
    List<GetApplicationTypeListRes> getApplicationTypeList();



    /**
     * 删除
     * @param id
     * @return
     */
    int deleteApplication(int id);


    /**
     * 查询
     * @param nowPage
     * @param pageSize
     * @return
     */
    Page<Application> findList(int nowPage, int pageSize);

    /**
     * 保存应用设置
     * @param
     * @return
     */
    int saveApplicationSetting(int applicationId);
}
