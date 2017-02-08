package com.azhen.exception;

/**
 * 秒杀关闭异常
 * Created by azhen on 16-12-9.
 */
public class CloseException extends BaseException{
    public CloseException(String message) {
        super(message);
    }

    public CloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
