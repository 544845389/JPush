package com.codingapi.push.server.api.contorller;

import com.codingapi.push.server.ao.GetApplicationTypeListRes;
import com.codingapi.push.server.ao.PushAllReq;
import com.codingapi.push.server.api.service.ApplicationService;
import com.lorne.core.framework.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
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



    @GetMapping("/saveApplication")
    public  int saveApplication(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("key") String key,
            @RequestParam("secret") String secret ) throws ServiceException {
        return applicationService.saveApplication(id , name , key , secret , type);
    }


    @GetMapping("/getApplicationTypeList")
    public List<GetApplicationTypeListRes> getApplicationTypeList( ){
        return applicationService.getApplicationTypeList();
    }





}
