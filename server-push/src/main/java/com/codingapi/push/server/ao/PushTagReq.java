package com.codingapi.push.server.ao;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class PushTagReq {

    @ApiModelProperty(value = "推送内容")
    private  String content;

    @ApiModelProperty(value = "标签推送")
    private  String tag;

    /**
     * 应用id
     */
    @ApiModelProperty(value = "推送应用Id")
    private  int applicationId;


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

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
