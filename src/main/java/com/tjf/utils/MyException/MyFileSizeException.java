package com.tjf.utils.MyException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/7 10:48
 * @description:
 */
public class MyFileSizeException extends Exception{
    private static final Logger LOGGER= LoggerFactory.getLogger(MyFileSizeException.class);
    private String message;
    private Throwable cause;
    public MyFileSizeException(){
        super();
    }
    public MyFileSizeException(String message) {
        super(message);
        LOGGER.warn(message);
        this.message=message;
    }
    public MyFileSizeException(String message, Throwable cause) {
        super(message,cause);
        LOGGER.warn(message+",cause is "+cause);
        this.message=message;
        this.cause=cause;
    }
    public MyFileSizeException(Throwable cause) {
        super(cause);
        LOGGER.warn("cause is "+cause);
        this.cause=cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
