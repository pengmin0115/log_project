package com.log.exception;

import java.io.Serializable;

/**
 * @author pengmin
 * @date 2021/2/23 13:55
 */

public class JsonResult implements Serializable {

    private Object data;
    private boolean flag;
    private String message;

    public JsonResult() {
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data, boolean flag, String message) {
        this.data = data;
        this.flag = flag;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
