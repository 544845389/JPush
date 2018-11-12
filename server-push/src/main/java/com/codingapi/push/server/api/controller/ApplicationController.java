package com.codingapi.push.server.api.controller;

import com.codingapi.push.server.ao.GetApplicationTypeListRes;
import com.codingapi.push.server.api.service.ApplicationService;
import com.codingapi.push.server.entity.Application;
import com.lorne.core.framework.exception.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description = "应用管理")
@RestController
@RequestMapping("application")
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
    @ApiOperation( value= "保存应用信息")
    @GetMapping("/saveApplication")
    public  int saveApplication(
          @ApiParam("应用Id") @RequestParam("id") int id,
          @ApiParam("应用名称")  @RequestParam("name") String name,
          @ApiParam("应用类型")  @RequestParam("type") String type,
          @ApiParam("应用key")  @RequestParam("key") String key,
          @ApiParam("应用密钥")  @RequestParam("secret") String secret ) throws ServiceException {
        return applicationService.saveApplication(id , name , key , secret , type);
    }


    /**
     * 初始化 某个应用设置信息
     * @return
     * @throws ServiceException
     */
    @ApiOperation( value= "初始化某个应用设置信息")
    @GetMapping("/saveApplicationSetting")
    public  int saveApplicationSetting(
            @ApiParam("应用Id")  @RequestParam("applicationId") int applicationId ){
        return applicationService.saveApplicationSetting(applicationId);
    }


    /**
     * 获取应用类型
     * @return
     */
    @ApiOperation( value= "获取应用类型")
    @GetMapping("/getApplicationTypeList")
    public List<GetApplicationTypeListRes> getApplicationTypeList( ){
        return applicationService.getApplicationTypeList();
    }


    /**
     * 删除应用
     * @param id
     * @return
     */
    @ApiOperation( value= "删除应用")
    @GetMapping("/deleteApplication")
    public  int deleteApplication(
            @ApiParam("应用Id")   @RequestParam("id") int id) {
        return applicationService.deleteApplication(id);
    }


    /**
     * 获取应用列表
     * @param nowPage
     * @param pageSize
     * @return
     */
    @ApiOperation( value= "获取应用列表")
    @GetMapping("/findList")
    public Page<Application> findList(
            @ApiParam("当前页")  @RequestParam("nowPage") int nowPage,
            @ApiParam("条数") @RequestParam("pageSize") int pageSize
    ) {
        return applicationService.findList(nowPage ,pageSize );
    }


}
