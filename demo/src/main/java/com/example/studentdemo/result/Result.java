package com.example.studentdemo.result;

import lombok.Data;

@Data
public class Result<T>{

    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(200, "success", data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<T>(500, msg, null);
    }

}
