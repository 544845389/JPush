package com.codingapi.push.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.push.server.config.WxPublic;
import com.codingapi.push.server.config.WxUrl;
import com.codingapi.push.server.dao.WxApplicationRepository;
import com.codingapi.push.server.entity.WxApplication;
import com.codingapi.push.server.service.WxPush;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 侯存路
 * @date 2018/11/7
 * @company codingApi
 * @description
 */
@Service
public class WxPushImpl implements WxPush {



    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private WxApplicationRepository wxApplicationRepository;



    /**
     * 获取 access_token
     * @return
     */
    @Override
    public  String   getAccessToken(int  wxApplicationId){

        WxApplication wxApplication =    wxApplicationRepository.findById(wxApplicationId).get();
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        String key = WxUrl.token_prefix+wxApplication.getId();
        String token =  redis.get(key);
        if(StringUtils.isEmpty(token)){
            // 获取最新的 token
            return  getToken(wxApplication);
        }else{
            // 剩余有效时间
            long time  = redisTemplate.getExpire(key , TimeUnit.SECONDS);
            if(time < 300){
                return  getToken(wxApplication);
            }else{
                return  token;
            }
        }
    }


   private String  getToken(WxApplication wxApplication){
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        String key = WxUrl.token_prefix+wxApplication.getId();

        String  res =  HttpUtils.get(WxUrl.get_access_token+"?grant_type=client_credential&appid="+wxApplication.getAppId()+"&secret="+wxApplication.getSecret());
        JSONObject  jsonObject =   JSONObject.parseObject(res);
        // token
        String accessToken  =  jsonObject.getString("access_token");
        // 有效期 7200 秒
        int expires_in  =  jsonObject.getIntValue("expires_in");
        redis.set(key , accessToken , expires_in , TimeUnit.SECONDS);
        return accessToken;
    }







}
