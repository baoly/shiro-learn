package com.baoly.shiro.result;

import lombok.Data;

/**
 * 同一结果返回
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    private Result() {

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
        return new Result(-1, msg, null);
    }

    public static Result error(String msg, Object data) {
        return new Result(-1, msg, data);
    }


}
