package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class WarnRecordDatasFindAll {
    private String id;
    private String warning_id;
    private String warning_code;
    private String warning_name;
    private String warning_mode;
    private String warning_time;
    private String warning_suggest;
    private String warning_method;
    private String deal_time;
    private String deal_username;
    private String device_id;
    private String device_code;
    private String device_name;
    private String boat_id;
    private String boat_code;
    private String boat_name;
    private LocalDateTime created_at;
    private Integer is_deal;
    private Integer is_delete;

}
