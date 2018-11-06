package com.codingapi.push.server.dao;


import com.codingapi.push.server.entity.ApplicationSetting;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 侯存路
 * @date 2018/11/6
 * @company codingApi
 * @description
 */
@Component
public interface ApplicationSettingRepository extends ElasticsearchRepository<ApplicationSetting, Integer> {



      ApplicationSetting findByApplicationIdAndParameter(int applicationId , String parameter);




}
