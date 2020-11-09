package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class FaultRecordDatas implements Serializable {
    private int ID;
    private int FAULT_ID;
    private String fault_code;
    private String fault_name;
    private String fault_type;
    private int device_id;
    private String device_code;
    private String device_name;
    private int boat_id;
    private String boat_code;
    private String boat_name;
    private int user_id;
    private String user_name;
    private int FAULT_DATA_ID;
    private String fault_method;
    private String fault_time;
    private String fault_mode;
    private String fault_suggest;
    private String deal_username;
    private String deal_time;
    private Integer is_deal;
    private Integer is_know;
    private Integer is_evaluation;
    private Integer is_delete;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
