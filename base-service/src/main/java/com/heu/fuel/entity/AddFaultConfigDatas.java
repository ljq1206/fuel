package com.heu.fuel.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import springfox.documentation.spring.web.json.Json;

import java.io.Serializable;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class AddFaultConfigDatas implements Serializable {
    private String fault_code;
    private String fault_name;
    private String fault_type;
    private String fault_algorithm;
    private String fault_mode;
    private String fault_suggest;
    private String fault_reason;
    private String fault_feature;
    private String fault_method;
    private String sign;
    private JSONObject[] parameter;



}
