package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class MainOptimizationFind implements Serializable {
    private String id;
    private String fault_code;
    private String fault_name;
    private String algorithm;
    private String reason;
    private String feature;
    private String method;
    private String fault_mode;
    private String suggest;
    private String count_month;

}
