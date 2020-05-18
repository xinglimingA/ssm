package com.xlm.common;

public enum ResponseCode {
    SUCCESS(0,"操作成功"),
    ERROR(1,"操作失败")
    ;

    private final int code;
    private final String msg;

    ResponseCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}