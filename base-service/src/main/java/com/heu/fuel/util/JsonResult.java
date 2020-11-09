package com.heu.fuel.util;

//zzx完成第一部分功能开发，由本地zzx分支上传提交到远程zzx分支
//@Data
public class JsonResult<T> {
    private String status;
    private String msg;
    private String code;
    private T data;
//    private Map<String,Object> map;
    /**
     * 若没有数据返回，默认状态码为 0，提示信息为“ ”
     */
    public JsonResult() {
        this.status = "ok";
        this.msg = " ";
        this.code = "0";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.status = "ok";
        this.msg = " ";
        this.code = "0";
    }

    /**
     * 有数据返回时，状态码为 0，默认提示信息为“ ”
     * @param data
     */
    public JsonResult(T data) {
        this.status = "ok";
        this.msg = " ";
        this.code = "0";
        this.data = data;
    }

    /**
     * 有数据返回，状态码为 0，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.status = "ok";
        this.msg = " ";
        this.code = "0";
        this.data = data;
    }
    //  get 和 set 方法

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

