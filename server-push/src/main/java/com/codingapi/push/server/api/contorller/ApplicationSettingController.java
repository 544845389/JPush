package com.codingapi.push.server.api.contorller;

import com.codingapi.push.server.api.service.ApplicationService;
import com.codingapi.push.server.api.service.ApplicationSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  应用管理
 */
@RestController
@RequestMapping("/applicationSetting")
public class ApplicationSettingController {


    @Autowired
    private ApplicationSettingService applicationSettingService;


    /**
     * 极光推送 参数配置
     * @param id
     * @param applicationId
     * @param parameter
     * @param value
     * @return
     */
    @GetMapping("/saveApplicationSetting")
    public  int saveApplicationSetting(
            @RequestParam("id") int id,
            @RequestParam("applicationId") int applicationId,
            @RequestParam("parameter") String parameter,
            @RequestParam("value") String value ){
        return applicationSettingService.saveApplicationSetting(id , applicationId , parameter , value);
    }



    


}
