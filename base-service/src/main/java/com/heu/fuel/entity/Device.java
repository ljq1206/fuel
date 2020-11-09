package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class Device implements Serializable {
    private int id;
    private String device_code;
    private String device_name;
    private int boat_id;
    private String boat_code;
    private String boat_name;
    private int FAULT_DEVICE_COUNT;
    private Float FAULT_DEVICE_SCALE;
    private int warning_device_count;
    private Float warning_device_scale;
    private int is_delete;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBoat_id() {
        return boat_id;
    }

    public void setBoat_id(int boat_id) {
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

    public int getFAULT_DEVICE_COUNT() {
        return FAULT_DEVICE_COUNT;
    }

    public void setFAULT_DEVICE_COUNT(int FAULT_DEVICE_COUNT) {
        this.FAULT_DEVICE_COUNT = FAULT_DEVICE_COUNT;
    }

    public Float getFAULT_DEVICE_SCALE() {
        return FAULT_DEVICE_SCALE;
    }

    public void setFAULT_DEVICE_SCALE(Float FAULT_DEVICE_SCALE) {
        this.FAULT_DEVICE_SCALE = FAULT_DEVICE_SCALE;
    }

    public int getWarning_device_count() {
        return warning_device_count;
    }

    public void setWarning_device_count(int warning_device_count) {
        this.warning_device_count = warning_device_count;
    }

    public Float getWarning_device_scale() {
        return warning_device_scale;
    }

    public void setWarning_device_scale(Float warning_device_scale) {
        this.warning_device_scale = warning_device_scale;
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
