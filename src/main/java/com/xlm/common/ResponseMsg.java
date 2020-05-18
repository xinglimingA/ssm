package com.xlm.common;

import java.io.Serializable;

public class ResponseMsg<T> implements Serializable{
    private int code;
    private String msg;
    private T data;

    private ResponseMsg(int code){
        this.code = code;
    }

    private ResponseMsg(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private ResponseMsg(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseMsg(int code,T data){
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ResponseMsg<T> createBySuccess(){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseMsg<T> createBySuccessMessage(String msg){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ResponseMsg<T> createBySuccess(T data){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ResponseMsg<T> createBySuccess(String msg,T data){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ResponseMsg<T> createByError(){
        return new ResponseMsg<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ResponseMsg<T> createByErrorMessage(String msg){
        return new ResponseMsg<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ResponseMsg<T> createByError(T data){
        return new ResponseMsg<T>(ResponseCode.ERROR.getCode(),data);
    }

    public static <T> ResponseMsg<T> createByError(String msg,T data){
        return new ResponseMsg<T>(ResponseCode.ERROR.getCode(),msg,data);
    }
}