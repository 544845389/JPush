package com.codingapi.push.server.service.impl;

import com.codingapi.push.server.service.Push;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("aPush")
public class APush implements Push {


    @Override
    public int sendAll(String content) {
        return 0;
    }

    @Override
    public int sendPushTag(String content, String tag) {
        return 0;
    }

    @Override
    public int sendPushMapTag(String content, String tag, Map<String, String> map) {
        return 0;
    }

    @Override
    public int sendPushMapTagThrough(String content, String tag, Map<String, String> map) {
        return 0;
    }

    @Override
    public int sendPushAlias(String content, String alias) {
        return 0;
    }

    @Override
    public int sendPushMapAlias(String content, String alias, Map<String, String> map) {
        return 0;
    }

    @Override
    public int sendPushMapAliasThrough(String content, String alias, Map<String, String> map) {
        return 0;
    }
}
