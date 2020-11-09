package com.heu.fuel.util;

import com.heu.fuel.entity.Boats;
import com.heu.fuel.service.CustomizeErrorCode;
import com.heu.fuel.service.impl.MyCustomizeErrorCode;

import java.util.List;
import java.util.Map;
//自定义错误状态  3.自定义异常类。。。
public class CustomizeException<T>{
    private String status;
    private String message;
    private Integer code;
    private T data;


    public CustomizeException(MyCustomizeErrorCode myCustomizeErrorCode, T data) {
        this.status = myCustomizeErrorCode.getStatus();
        this.message = myCustomizeErrorCode.getMessage();
        this.code = myCustomizeErrorCode.getCode();
        this.data = data;

    }



    public CustomizeException(){
        this.code =0;
        this.message = " ";
        this.status = "ok";
    };

    //data
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public String getStatus(){
        return status;
    }
    public String getMessage(){
        return message;
    }
    public Integer getCode() {
        return code;
    }

}

