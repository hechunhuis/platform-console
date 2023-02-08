package com.platform.gateway.captcha.router;

import com.platform.gateway.captcha.handler.CaptchaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @ClassName CaptchaRouter
 * @Description 验证码路由
 * @Author hechunhui
 * @Date 2023/2/8 14:22
 * @Version 1.0
 */
@Configuration
public class CaptchaRouter {

    @Bean
    public RouterFunction<ServerResponse> captchaRouterFunction(CaptchaHandler captchaHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/captcha")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), captchaHandler::handle);
    }

}
