package com.heu.fuel.service;


//自定义错误1.状态、状态码、信息接口
public interface CustomizeErrorCode {
    /**
     * 获取错误状态
     * @return 错误状态
     */
    public String getStatus();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    public String getMessage();

    /**
     * 获取错误状态码
     * @return 错误状态码
     */
    public Integer getCode();

}
