package com.log.exception;

/**
 * @author pengmin
 * @date 2021/2/23 13:49
 */

public class MyException extends RuntimeException{

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
