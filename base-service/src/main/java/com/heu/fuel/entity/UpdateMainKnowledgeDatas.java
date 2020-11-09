package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class UpdateMainKnowledgeDatas implements Serializable {
    private String fault_id;
    private String fault_code;
    private String fault_name;
    private String fault_type;
    private String fault_mode;
    private String reason;
    private String feature;
    private String method;
    private String suggest;
    private Long fault_month_count;
    private Long fault_count;
    private Float fault_scale;
    private Integer is_main;
    private Integer is_delete;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
