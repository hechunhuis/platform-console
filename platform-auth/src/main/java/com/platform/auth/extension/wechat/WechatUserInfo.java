package com.platform.auth.extension.wechat;

import lombok.Data;

/**
 * @ClassName WechatUserInfo
 * @Description 微信用户信息
 * @Author hechunhui
 * @Date 2023/2/8 15:07
 * @Version 1.0
 */
@Data
public class WechatUserInfo {
    private String avatarUrl;

    private String city;

    private String country;

    private Integer gender;

    private String language;

    private String nickName;

    private String province;

}
