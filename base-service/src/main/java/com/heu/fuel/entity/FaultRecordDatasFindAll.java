package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class FaultRecordDatasFindAll implements Serializable {
    private String id;
    private String fault_id;
    private String fault_code;
    private String fault_name;
    private String device_id;
    private String device_code;
    private String device_name;
    private String boat_id;
    private String boat_code;
    private String boat_name;
    private String fault_mode;
    private String fault_suggest;
    private String fault_time;
    private String fault_method;
    private String deal_time;
    private String deal_username;
    private LocalDateTime created_at;
    private String fault_data_id;
    private Integer is_deal;
    private Integer is_evaluation;
    private Integer is_delete;

}
