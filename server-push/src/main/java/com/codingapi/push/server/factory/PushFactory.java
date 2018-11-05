package com.codingapi.push.server.factory;

import com.codingapi.push.server.service.Push;
import com.codingapi.push.server.utils.BeanUtil;

public class PushFactory {

    public static Push  createPush(String type){
        Push push =  (Push)BeanUtil.getBean(type);
        return  push;
    }

}
