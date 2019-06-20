package com.example.demo1.common;

public enum ReturnCode {

    SUCCESS(100,"操作成功"),

    FAILURE(-1,"请求失败");

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ReturnCode(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }
}
