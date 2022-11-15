package com.platform.user.controller;

import com.platform.user.config.NacosConfigInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tomato<hechunhui_email@163.com>
 * @date : 2022/11/12 20:29
 * @className : LoginController
 * @description: 登录Controller
 */
@RestController
@Slf4j
@RefreshScope
public class LoginController extends BaseController{

    @Autowired
    private NacosConfigInfo nacosConfigInfo;

    @GetMapping
    public Map<String, String> getConfigInfo() {
        Map<String, String> result = new HashMap<>();
        result.put("serverAddr", nacosConfigInfo.getServerAddr());
        result.put("prefix", nacosConfigInfo.getPrefix());
        result.put("group", nacosConfigInfo.getGroup());
        result.put("namespace", nacosConfigInfo.getNamespace());
        return result;
    }
}
