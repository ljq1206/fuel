package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class DeviceFindAll implements Serializable {
    private String id;
    private String device_code;
    private String device_name;
    private String boat_id;
    private String boat_code;
    private String boat_name;
    private LocalDateTime created_at;
    private int is_delete;

    public int getIs_delete() {
        return is_delete;
    }
    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDevice_code() {
        return device_code;
    }
    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }

    public String getDevice_name() {
        return device_name;
    }
    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getBoat_id() {
        return boat_id;
    }
    public void setBoat_id(String boat_id) {
        this.boat_id = boat_id;
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
}
