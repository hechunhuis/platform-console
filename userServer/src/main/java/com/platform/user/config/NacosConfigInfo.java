package com.platform.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : tomato<hechunhui_email@163.com>
 * @date : 2022/11/15 6:38
 * @className : NacosConfigInfo
 * @description: TODO
 */
@ConfigurationProperties(prefix = "spring.cloud.nacos.config")
@Component
@Data
public class NacosConfigInfo {
    /**
     * Nacos server address.
     */
    private String serverAddr;

    /**
     * Data Id prefix.
     */
    private String prefix;

    /**
     * Nacos group.
     */
    private String group;

    /**
     * Nacos namespace.
     */
    private String namespace;
}
