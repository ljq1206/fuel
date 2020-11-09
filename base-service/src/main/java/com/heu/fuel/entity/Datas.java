package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

//1. 建实体类

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class Datas implements Serializable {
    private String id; //主键  自增
    private String find_key;
    private String find_value;
    private String sort_key;
    private String sort_value;
    private Integer date;
    private String fault_id;
    private String device_id;
    private String fault_data_id;
    private String start_time;
    private String end_time;
    private String boat_id;
    private String device_code;


}

