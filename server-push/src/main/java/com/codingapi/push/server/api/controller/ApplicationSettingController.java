package com.codingapi.push.server.api.controller;

import com.codingapi.push.server.api.service.ApplicationSettingService;
import com.codingapi.push.server.entity.ApplicationSetting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  应用设置
 */
@Api(description = "应用设置")
@RestController
@RequestMapping("applicationSetting")
public class ApplicationSettingController {


    @Autowired
    private ApplicationSettingService applicationSettingService;


    /**
     * 极光推送 参数配置
     * @param id
     * @param applicationId
     * @param parameter  必须填写 Setting 枚举类 中已存在的值
     * @param value
     * @return
     */
    @GetMapping("/saveApplicationSetting")
    public  int saveApplicationSetting(
            @ApiParam("Id")  @RequestParam("id") int id,
            @ApiParam("应用Id")  @RequestParam("applicationId") int applicationId,
            @ApiParam("参数key")  @RequestParam("parameter") String parameter,
            @ApiParam("参数说明") @RequestParam("info") String info,
            @ApiParam("参数值") @RequestParam("value") String value
    ){
        return applicationSettingService.saveApplicationSetting(id , applicationId , parameter , value , info);
    }





    /**
     * 极光推送 参数配置
     */
    @GetMapping("/updateApplicationSetting")
    public  int updateApplicationSetting(
            @ApiParam("Id")  @RequestParam("id") int id,
            @ApiParam("参数值") @RequestParam("value") String value ){
        return applicationSettingService.updateApplicationSetting(id , value );
    }




    /**
     * 获取应用的参数设置列表
     */
    @GetMapping("/findApplicationSettingByApplicationId")
    public List<ApplicationSetting> findApplicationSettingByApplicationId(
            @ApiParam("应用Id")
            @RequestParam("ApplicationId") int id ){
        return applicationSettingService.findApplicationSettingByApplicationId(id);
    }






}
