package com.codingapi.push.server.factory;

import com.codingapi.push.server.service.Push;
import com.codingapi.push.server.helper.BeanHelper;

public class PushFactory {

    public static Push  createPush(String type){
        Push push =  (Push) BeanHelper.getBean(type);
        return  push;
    }






}
