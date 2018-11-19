package com.codingapi.push.server.api.controller.wxpublic;

import com.codingapi.push.server.api.service.WxApplicationService;
import com.codingapi.push.server.entity.WxApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  微信 应用管理
 */
@RestController
@RequestMapping("/wxApplication")
public class WxApplicationController {


    @Autowired
    private WxApplicationService wxApplicationService;



    @GetMapping("/saveOrWxApplication")
    public  int saveOrWxApplication(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("appId") String appId,
            @RequestParam("secret") String secret ){
        return wxApplicationService.saveOrWxApplication(id , name , appId , secret );
    }


    @GetMapping("/deleteWxApplication")
    public  int deleteWxApplication(
            @RequestParam("id") int id){
        return wxApplicationService.deleteWxApplication(id);
    }



    @GetMapping("/findWxApplicationList")
    public Page<WxApplication> findWxApplicationList(){
        return wxApplicationService.findWxApplicationList();
    }


}
