package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

//1. 建实体类

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class BoatsFindAll implements Serializable {
    private String id; //主键  自增
    private String boat_code; //船的代码
    private String boat_name; //船的名字
    private LocalDateTime created_at;  //创建时间
    private int is_delete; //删除标志位

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
}


