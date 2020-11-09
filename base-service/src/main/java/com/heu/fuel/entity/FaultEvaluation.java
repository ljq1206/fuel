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
public class FaultEvaluation implements Serializable {
    private int id; //主键  自增
    private String fault_record_id; //故障记录表id
    private String operation_user_name; //评价人用户名
    private int grade; //故障判定评分（0-100）
    private int fault_id;
    private String fault_code;
    private String fault_name;
    private String fault_mode;
    private int device_id;
    private String device_code;
    private String device_name;
    private int boat_id;
    private String boat_code;
    private String boat_name;
    private String fault_feature; //实际故障现象
    private String fault_reason; //实际故障原因
    private String fault_method; //实际解决方法
    private int is_delete; //删除标志位
    private LocalDateTime created_at;  //创建时间
    private LocalDateTime updated_at;  //更新时间

}

