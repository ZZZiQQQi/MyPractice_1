package com.example.demo.enums;

public enum ResultEnum {

    success(200,"success"),
    fail(404,"fail");

    private int code;
    private String msg;
    ResultEnum(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg(int code) {
       return msg;
    }


}
