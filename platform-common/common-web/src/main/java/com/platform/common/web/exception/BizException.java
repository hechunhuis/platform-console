package com.platform.common.web.exception;

import com.platform.common.result.IResultCode;
import lombok.Getter;

/**
 * @ClassName BizException
 * @Description 自定义业务异常
 * @Author hechunhui
 * @Date 2023/2/8 14:17
 * @Version 1.0
 */
@Getter
public class BizException extends RuntimeException {

    public IResultCode resultCode;

    public BizException(IResultCode errorCode) {
        super(errorCode.getMsg());
        this.resultCode = errorCode;
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
