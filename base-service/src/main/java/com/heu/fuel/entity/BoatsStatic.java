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
public class BoatsStatic implements Serializable {
    private int id; //主键  自增
    private int boat_id;
    private String boat_code; //船的代码
    private String boat_name; //船的名字
    private int FAULT_COUNT_SEVEN;
    private float FAULT_SCALE_SEVEN;
    private int FAULT_COUNT_MONTH;
    private float FAULT_SCALE_MONTH;
    private int FAULT_COUNT_QUARTER;
    private float FAULT_SCALE_QUARTER;
    private int FAULT_COUNT_YEAR;
    private float FAULT_SCALE_YEAR;
    private int FAULT_COUNT_ALL;
    private float FAULT_SCALE_ALL;
    private int WARNING_COUNT_SEVEN;
    private float WARNING_SCALE_SEVEN;
    private int WARNING_COUNT_MONTH;
    private float WARNING_SCALE_MONTH;
    private int WARNING_COUNT_QUARTER;
    private float WARNING_SCALE_QUARTER;
    private int WARNING_COUNT_YEAR;
    private float WARNING_SCALE_YEAR;
    private int WARNING_COUNT_ALL;
    private float WARNING_SCALE_ALL;
}

