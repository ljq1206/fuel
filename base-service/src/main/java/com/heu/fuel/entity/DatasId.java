package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//1. 建实体类

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class DatasId implements Serializable {
    private Integer id; //主键  自增
    private Integer fault_id;
    private String user_id;
    private String username;

}

