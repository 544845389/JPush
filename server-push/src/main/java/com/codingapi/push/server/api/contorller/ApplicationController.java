package com.codingapi.push.server.api.contorller;

import com.codingapi.push.server.ao.GetApplicationTypeListRes;
import com.codingapi.push.server.ao.PushAllReq;
import com.codingapi.push.server.api.service.ApplicationService;
import com.codingapi.push.server.entity.Application;
import com.lorne.core.framework.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  应用管理
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {


    @Autowired
    private ApplicationService applicationService;


    /**
     * 保存应用信息
     * @param id
     * @param name
     * @param type
     * @param key
     * @param secret
     * @return
     * @throws ServiceException
     */
    @GetMapping("/saveApplication")
    public  int saveApplication(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("key") String key,
            @RequestParam("secret") String secret ) throws ServiceException {
        return applicationService.saveApplication(id , name , key , secret , type);
    }


    /**
     * 保存应用设置信息
     * @return
     * @throws ServiceException
     */
    @GetMapping("/saveApplicationSetting")
    public  int saveApplicationSetting(
            @RequestParam("applicationId") int applicationId ){
        return applicationService.saveApplicationSetting(applicationId);
    }


    /**
     * 获取应用类型
     * @return
     */
    @GetMapping("/getApplicationTypeList")
    public List<GetApplicationTypeListRes> getApplicationTypeList( ){
        return applicationService.getApplicationTypeList();
    }


    /**
     * 删除应用
     * @param id
     * @return
     */
    @GetMapping("/deleteApplication")
    public  int deleteApplication(
            @RequestParam("id") int id) {
        return applicationService.deleteApplication(id);
    }


    /**
     * 获取应用列表
     * @param id
     * @param pageSize
     * @return
     */
    @GetMapping("/findList")
    public Page<Application> findList(
            @RequestParam("nowPage") int id,
            @RequestParam("pageSize") int pageSize
    ) {
        return applicationService.findList(id ,pageSize );
    }


}
