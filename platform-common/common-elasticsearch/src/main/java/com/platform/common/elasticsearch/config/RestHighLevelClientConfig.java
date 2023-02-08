package com.platform.common.elasticsearch.config;

import lombok.Setter;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName RestHighLevelClientConfig
 * @Description ES客户端配置类
 * @Author hechunhui
 * @Date 2023/2/8 12:15
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "spring.elasticsearch.rest")
@Configuration
public class RestHighLevelClientConfig {

    @Setter
    private List<String> clusterNodes;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        HttpHost[] hosts = clusterNodes.stream()
                .map(this::buildHttpHost) // eg: new HttpHost("127.0.0.1", 9200, "http")
                .toArray(HttpHost[]::new);
        return new RestHighLevelClient(RestClient.builder(hosts));
    }

    private HttpHost buildHttpHost(String node) {
        String[] nodeInfo = node.split(":");
        return new HttpHost(nodeInfo[0].trim(), Integer.parseInt(nodeInfo[1].trim()), "http");
    }
}
