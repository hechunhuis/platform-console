package com.platform.system.api;

import com.platform.common.result.Result;
import com.platform.system.dto.UserAuthInfo;
import com.platform.system.api.fallback.UserFeignFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "platform-system", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users/{username}/authinfo")
    Result<UserAuthInfo> getUserAuthInfo(@PathVariable String username);
}
