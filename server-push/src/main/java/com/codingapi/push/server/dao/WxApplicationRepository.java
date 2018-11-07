package com.codingapi.push.server.dao;


import com.codingapi.push.server.entity.WxApplication;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Component
public interface WxApplicationRepository extends ElasticsearchRepository<WxApplication, Integer> {






}
