package com.heu.fuel.entity;

import lombok.Data;

@Data
public class NotDealFault {
    private String id;
    private String fault_id;
    private String fault_code;
    private String fault_name;
    private String fault_mode;
    private String fault_suggest;
    private String fault_boat_id;
    private String fault_boat_code;
    private String fault_boat_name;
    private String fault_device_id;
    private String fault_device_code;
    private String fault_device_name;
    private String fault_time;
    private String fault_deal_method;
    private Integer is_deal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFault_id() {
        return fault_id;
    }

    public void setFault_id(String fault_id) {
        this.fault_id = fault_id;
    }

    public String getFault_code() {
        return fault_code;
    }

    public void setFault_code(String fault_code) {
        this.fault_code = fault_code;
    }

    public String getFault_name() {
        return fault_name;
    }

    public void setFault_name(String fault_name) {
        this.fault_name = fault_name;
    }

    public String getFault_boat_id() {
        return fault_boat_id;
    }

    public void setFault_boat_id(String fault_boat_id) {
        this.fault_boat_id = fault_boat_id;
    }

    public String getFault_boat_code() {
        return fault_boat_code;
    }

    public void setFault_boat_code(String fault_boat_code) {
        this.fault_boat_code = fault_boat_code;
    }

    public String getFault_boat_name() {
        return fault_boat_name;
    }

    public void setFault_boat_name(String fault_boat_name) {
        this.fault_boat_name = fault_boat_name;
    }

    public String getFault_device_id() {
        return fault_device_id;
    }

    public void setFault_device_id(String fault_device_id) {
        this.fault_device_id = fault_device_id;
    }

    public String getFault_device_code() {
        return fault_device_code;
    }

    public void setFault_device_code(String fault_device_code) {
        this.fault_device_code = fault_device_code;
    }

    public String getFault_device_name() {
        return fault_device_name;
    }

    public void setFault_device_name(String fault_device_name) {
        this.fault_device_name = fault_device_name;
    }

    public String getFault_time() {
        return fault_time;
    }

    public void setFault_time(String fault_time) {
        this.fault_time = fault_time;
    }

    public String getFault_deal_method() {
        return fault_deal_method;
    }

    public void setFault_deal_method(String fault_deal_method) {
        this.fault_deal_method = fault_deal_method;
    }

    public Integer getIs_deal() {
        return is_deal;
    }

    public void setIs_deal(Integer is_deal) {
        this.is_deal = is_deal;
    }
}
