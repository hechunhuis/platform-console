package com.platform.common.constant;

/**
 * @ClassName SecurityConstants
 * @Description 安全常量类
 * @Author hechunhui
 * @Date 2023/2/8 11:28
 * @Version 1.0
 */
public interface SecurityConstants {
    /**
     * 黑名单TOKEN Key前缀
     */
    String BLACKLIST_TOKEN_PREFIX = "AUTH:BLACKLIST_TOKEN:";

    /**
     * 验证码key前缀
     */
    String VERIFY_CODE_KEY_PREFIX = "AUTH:VERIFY_CODE:";

    /**
     * 短信验证码key前缀
     */
    String SMS_CODE_PREFIX = "SMS_CODE:";

    /**
     * 接口文档 Knife4j 测试客户端ID
     */
    String TEST_CLIENT_ID = "client";

    /**
     * 系统管理 web 客户端ID
     */
    String ADMIN_CLIENT_ID = "platform-admin";

    /**
     * 移动端（H5/Android/IOS）客户端ID
     */
    String APP_CLIENT_ID = "platform-app";

    /**
     * 微信小程序客户端ID
     */
    String WEBAPP_CLIENT_ID = "platform-webapp";
}
