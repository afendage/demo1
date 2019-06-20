package com.example.demo1.common;

import lombok.Data;

/**
 * 通用格式返回对象
 */
@Data
public class ResultInfo<T> {

    /** 返回码*/
    private Integer code;
    /** 描述*/
    private String msg;
    /** 数据*/
    private T data;

    public ResultInfo(){}

    public ResultInfo(ReturnCode returnCode){
        this.msg=returnCode.getMsg();
        this.code=returnCode.getCode();
    }

    public ResultInfo(ReturnCode returnCode,T data){
        this.msg=returnCode.getMsg();
        this.code=returnCode.getCode();
        this.data=data;
    }

    public static ResultInfo SUCCESS(){
        return new ResultInfo(ReturnCode.SUCCESS);
    }
    public static <T> ResultInfo SUCCESS(T data){
        return new ResultInfo(ReturnCode.SUCCESS,data);
    }

    public static ResultInfo FAILURE(){
        return new ResultInfo(ReturnCode.FAILURE);
    }
    public static <T> ResultInfo FAILURE(T data){
        return new ResultInfo(ReturnCode.FAILURE,data);
    }
}
