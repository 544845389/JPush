package com.codingapi.push.server.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;
@ApiModel
public class PushTagThroughReq {

    @ApiModelProperty(value = "推送内容")
    private  String content;

    @ApiModelProperty(value = "推送标签")
    private  String tag;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
