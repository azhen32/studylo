package com.azhen.exception;

import com.azhen.constants.StatEnum;

/**
 * 在线学习系统最基本异常
 */
public class BaseException  extends RuntimeException{
    private int code;
    private String message;
    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BaseException(int code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(StatEnum statEnum) {
        this.code = statEnum.getState();
        this.message = statEnum.getStateInfo();
    }
}
