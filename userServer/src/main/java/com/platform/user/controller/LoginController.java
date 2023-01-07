package com.platform.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.platform.user.config.UserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : tomato<hechunhui_email@163.com>
 * @date : 2022/11/12 20:29
 * @className : LoginController
 * @description: 登录Controller
 */
@RestController
@Slf4j
@RefreshScope
public class LoginController {

    @Autowired
    private UserConfig userConfig;

    @GetMapping
    @ResponseBody
    public String getConfigInfo() {
        return userConfig.toString();
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHostKey(@RequestParam(value = "param1", required = false) String param1,
                              @RequestParam(value = "param2", required = false) String param2) {
        log.info(String.format("/testHostKey param1:%s param2:%s", param1, param2));
        return String.format("/testHostKey param1:%s param2:%s", param1, param2);
    }
    public String dealTestHotKey(String param1, String param2, BlockException blockException) {
        return "服务挂了，非常抱歉,o(╥﹏╥)o";
    }
}
