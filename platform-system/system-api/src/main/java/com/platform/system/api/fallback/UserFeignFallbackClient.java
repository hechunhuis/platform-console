package com.platform.system.api.fallback;

import com.platform.common.result.Result;
import com.platform.common.result.ResultCode;
import com.platform.system.api.UserFeignClient;
import com.platform.system.dto.UserAuthInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserFeignFallbackClient
 * @Description 用户调用回调
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public Result<UserAuthInfo> getUserAuthInfo(String username) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return Result.failed(ResultCode.DEGRADATION);
    }
}
