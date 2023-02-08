package com.platform.common.redis.config;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RedissonConfig
 * @Description 分布式锁 Redisson 配置
 * @Author hechunhui
 * @Date 2023/2/8 14:07
 * @Version 1.0
 */
@ConditionalOnProperty(prefix = "redisson", name = "address")
@ConfigurationProperties(prefix = "redisson")
@Configuration
public class RedissonConfig {

    @Setter
    private String address;
    @Setter
    private String password;
    @Setter
    private Integer database;
    @Setter
    private Integer minIdle;// 默认最小空闲连接数

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress(address);
        singleServerConfig.setDatabase(database);
        singleServerConfig.setConnectionMinimumIdleSize(minIdle);
        if (StrUtil.isNotBlank(password)) {
            singleServerConfig.setPassword(password);
        }
        return Redisson.create(config);
    }

}
