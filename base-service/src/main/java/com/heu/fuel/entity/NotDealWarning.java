package com.heu.fuel.entity;

import lombok.Data;

@Data
public class NotDealWarning {
    private String id;
    private String warning_id;
    private String warning_code;
    private String warning_name;
    private String warning_mode;
    private String warning_suggest;
    private String warning_boat_id;
    private String warning_boat_code;
    private String warning_boat_name;
    private String warning_device_id;
    private String warning_device_code;
    private String warning_device_name;
    private String warning_time;
    private String warning_deal_method;
    private Integer is_deal;

}
