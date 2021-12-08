package com.baoly.shiro.result;

/**
 * 同一结果返回
 */
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    private Result() {

    }

    private Result(String msg) {
        this.msg = msg;
    }

    private Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result ok(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result ok(String msg) {
        return new Result(200, msg, null);
    }

    public static Result error(String msg) {
        return new Result(msg);
    }

    public static Result error(String msg, Object data) {
        return new Result(-1, msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
