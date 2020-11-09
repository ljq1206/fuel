package com.heu.fuel.service.impl;

import com.heu.fuel.service.CustomizeErrorCode;

//枚举类型的错误  2. 状态码
public enum  MyCustomizeErrorCode implements CustomizeErrorCode {
    /**
     * 0:"操作成功!"
     */
    OPERATION_THIS_CORRECT("ok", "", 0),
    FIND_ALL_CORRECT("ok", "", 0),
    ADD_BOAT_CORRECT("ok", "", 0),
    UPDATE_BOAT_CORRECT("ok", "", 0),
    DELETE_BOAT_CORRECT("ok", "", 0),
    /**
     * 3005:"密码不正确!"
     */
    PASS_NOT_CORRECT("wrong","密码不正确!请重新尝试!", 3005),
    /**
     * 2005:"没有找到这一条历史信息!有人侵入数据库强制删除了!"
     */
    INTRODUCTION_NOT_FOUND("wrong","没有找到这一条历史信息!有人侵入数据库强制删除了!", 2005),

    INSERT_BOAT_REPEAT_DATA("wrong","船只代码或名称已存在，请重新输入！", 2007),
    INSERT_DEVICE_REPEAT_DATA("wrong","设备代码或名称已存在，请重新输入！", 2007),
    INTRODUCTION_DATE_NOT_FOUND("wrong","date输入错误!", 2006),
    /**
     * 404:没有找到对应的请求路径
     */
    PAGE_NOT_FOUND("wrong","你要请求的页面好像暂时飘走了...要不试试请求其它页面?", 404),
    /**
     * 500:服务端异常
     */
    INTERNAL_SERVER_ERROR("wrong","服务器冒烟了...要不等它降降温后再来访问?", 500),
    /**
     * 2001:未知异常
     */
    UNKNOWN_SERVER_ERROR("wrong", "未知异常,请联系管理员!",2001);

    private String status;
    private String message;
    private Integer code;



    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    MyCustomizeErrorCode(String status, String message, Integer code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }


}

