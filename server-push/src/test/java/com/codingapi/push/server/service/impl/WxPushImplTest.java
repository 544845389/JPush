package com.codingapi.push.server.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 侯存路
 * @date 2018/11/7
 * @company codingApi
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxPushImplTest {


    @Autowired
    private   WxPushImpl wxPush;


    @Test
    public void getAccessToken() throws Exception {

        System.out.println(wxPush.getAccessToken(1));

    }


}