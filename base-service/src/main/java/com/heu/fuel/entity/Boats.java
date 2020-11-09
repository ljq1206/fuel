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
public class Boats implements Serializable {
    private int id; //主键  自增
    private String boat_code; //船的代码
    private String boat_name; //船的名字
    private int fault_boat_count; //错误总数
    private Float fault_boat_scale; //错误百分比
    private int warning_boat_count; //警告数
    private Float warning_boat_scale; //警告百分比
    private int is_delete; //删除标志位
    private LocalDateTime created_at;  //创建时间
    private LocalDateTime updated_at;  //更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoat_code() {
        return boat_code;
    }

    public void setBoat_code(String boat_code) {
        this.boat_code = boat_code;
    }

    public String getBoat_name() {
        return boat_name;
    }

    public void setBoat_name(String boat_name) {
        this.boat_name = boat_name;
    }

    public int getFault_boat_count() {
        return fault_boat_count;
    }

    public void setFault_boat_count(int fault_boat_count) {
        this.fault_boat_count = fault_boat_count;
    }

    public Float getFault_boat_scale() {
        return fault_boat_scale;
    }

    public void setFault_boat_scale(Float fault_boat_scale) {
        this.fault_boat_scale = fault_boat_scale;
    }

    public int getWarning_boat_count() {
        return warning_boat_count;
    }

    public void setWarning_boat_count(int warning_boat_count) {
        this.warning_boat_count = warning_boat_count;
    }

    public Float getWarning_boat_scale() {
        return warning_boat_scale;
    }

    public void setWarning_boat_scale(Float warning_boat_scale) {
        this.warning_boat_scale = warning_boat_scale;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}

