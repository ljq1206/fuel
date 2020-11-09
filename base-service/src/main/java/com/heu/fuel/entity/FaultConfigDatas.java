package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class FaultConfigDatas implements Serializable {
    private int id;
    private int fault_id;
    private String parameter;
    private String method;
    private String threshold;
    private String sign;
}
