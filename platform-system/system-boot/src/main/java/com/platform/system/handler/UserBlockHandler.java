package com.platform.system.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.platform.common.result.Result;
import com.platform.system.pojo.vo.user.UserLoginVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserBlockHandler
 * @Description 用户接口降级逻辑
 * @Author hechunhui
 * @Date 2023/2/8 14:57
 * @Version 1.0
 */
@Slf4j
public class UserBlockHandler {

    /**
     * 获取当前登录用户信息的熔断降级处理
     *
     * @param blockException
     * @return
     */
    public static Result<UserLoginVO> handleGetCurrentUserBlock(BlockException blockException) {
        return Result.success(new UserLoginVO());
    }


    public static Result handleGetUserByUsernameBlock(String username, BlockException blockException) {
        log.info("降级了：{}", username);
        return Result.failed("降级了");
    }
}
