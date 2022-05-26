package com.atguigu.common.exception;

/*
* 通过枚举统一管理状态吗
*
* */
public enum  BizCodeEnum {
    VALID_EXCEPTION(10001,"参数校验异常"),
    UNKNOW_EXCEPTION(10000,"未知异常");

    private int code;
    private String msg;
    BizCodeEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
    public int getCode(){
        return code;
    }
}
