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
public class PreventDatas implements Serializable {
    private int id; //主键  自增
    private int boat_id;
    private String boat_code;
    private String boat_name;
    private int device_id;
    private String device_code;
    private String device_name;
    private String module_name;
    private String maintenance_name;
    private String maintenance_method;
    private String maintenance_plan;
    private String fit_time;
    private Integer is_remove;
    private Integer remove_sign;
    private Integer is_delete;
    private LocalDateTime created_at;  //创建时间

}

