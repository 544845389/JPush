package com.codingapi.push.server.api.contorller.wxpublic;

import com.codingapi.push.server.api.service.WxPublicTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description  微信公众平台推送消息
 */
@RestController
@RequestMapping("/wxPublicTemplatePush")
public class WxPublicTemplateController {


    @Autowired
    private WxPublicTemplateService  wxPublicTemplateService;


    /**
     * 获取模板列表
     * @param wxApplicationId
     * @return
     */
    @GetMapping("/getWxTemplateList")
    public List<Map<String,String>> getWxTemplateList(@RequestParam("wxApplicationId") int wxApplicationId){
        return wxPublicTemplateService.getWxTemplateList(wxApplicationId);
    }




    /**
     * 删除模板
     * @param wxApplicationId
     * @return
     */
    @GetMapping("/deleteWxTemplateById")
    public int deleteWxTemplateById(
            @RequestParam("wxApplicationId") int wxApplicationId,
            @RequestParam("templateId") String templateId
    ){
        return wxPublicTemplateService.deleteWxTemplateById(wxApplicationId , templateId);
    }




}
