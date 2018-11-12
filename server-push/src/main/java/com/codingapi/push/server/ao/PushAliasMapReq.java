package com.codingapi.push.server.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;
@ApiModel
public class PushAliasMapReq {

    @ApiModelProperty(value = "推送内容")
    private  String content;

    @ApiModelProperty(value = "别名推送")
    private  String alias;

    @ApiModelProperty(value = "推送Map数据")
    private Map<String,String> map;

    /**
     * 应用id
     */
    @ApiModelProperty(value = "推送应用Id")
    private  int applicationId;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
