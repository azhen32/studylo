package com.azhen.exception;

/**
 * 重复秒杀异常
 * Created by azhen on 16-12-9.
 */
public class RepeatKillException extends BaseException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
