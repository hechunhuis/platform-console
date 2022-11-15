package com.platform.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : tomato<hechunhui_email@163.com>
 * @date : 2022/11/12 19:32
 * @className : UserApplication
 * @description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(UserApplication.class, args);
//        String userName = applicationContext.getEnvironment().getProperty("user.name");
//        String userAge = applicationContext.getEnvironment().getProperty("user.age");
//        System.err.println("user name :" +userName+"; age: "+userAge);
    }
}
