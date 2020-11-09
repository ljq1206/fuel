package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class MainKnowledgeDatas implements Serializable {
    private int id;
    private String fault_code;
    private String fault_name;
    private String fault_type;
    private String fault_algorithm;
    private String fault_reason;
    private String fault_mode;
    private String fault_suggest;
    private String fault_feature;
    private String fault_method;
    private int fault_month_count;
    private int fault_count;
    private Float fault_scale;
    private Integer is_main;
    private Integer is_delete;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


}
