package com.platform.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author : tomato<hechunhui_email@163.com>
 * @date : 2022/12/17 13:37
 * @className : UserConfig
 * @description: TODO
 */
@Data
@Component
@RefreshScope
public class UserConfig {

    @Value("${config.info}")
    private String configInfo;
}
