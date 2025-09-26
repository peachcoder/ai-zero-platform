package com.tao.taoaicodemother.exception;

import lombok.Getter;

/**
 * ClassName: BusinessException
 * Package: com.tao.taoaicodemother.exception
 * Description:
 *
 * @Author zt
 * @Create 2025/9/27 0:45
 * @Version 1.0
 */
@Getter
public class BusinessException extends RuntimeException {
    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }


}
