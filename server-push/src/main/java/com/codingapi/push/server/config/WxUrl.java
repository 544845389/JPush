package com.codingapi.push.server.config;

/**
 * @author 侯存路
 * @date 2018/11/7
 * @company codingApi
 * @description
 */
public class WxUrl {


    /**
     * 保存 token 的前缀
     */
    public static String  token_prefix = "wx_public_msg_";


    /**
     * 获取 token
     */
    public static String  get_access_token = "https://api.weixin.qq.com/cgi-bin/token";


    /**
     * 获取微信公众号 模板列表
     */
    public static String get_template_list = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template";


    /**
     * 删除模板
     */
    public static String delete_template_list = "https://api.weixin.qq.com/cgi-bin/template/del_private_template";


    /**
     * 发送模板消息
     */
    public static String send_msg = "https://api.weixin.qq.com/cgi-bin/message/template/send";


    /**
     * 根据OpenID列表群发【订阅号不可用，服务号认证后可用】
     */
    public static String mass_send_msg = "https://api.weixin.qq.com/cgi-bin/message/mass/send";



}
