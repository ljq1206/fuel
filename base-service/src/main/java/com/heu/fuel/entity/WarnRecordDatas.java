package com.heu.fuel.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class WarnRecordDatas implements Serializable {
    private Long id;
    private Long warning_id;
    private String warning_code;
    private String warning_type;
    private String warning_name;
    private Long boat_id;
    private String boat_code;
    private String boat_name;
    private Long device_id;
    private String device_code;
    private String device_name;
    private Long user_id;
    private String user_name;
    private String warning_data_id;
    private String warning_method;
    private String warning_time;
    private Integer is_deal;
    private Integer is_delete;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getWarning_id() {
        return warning_id;
    }
    public void setWarning_id(Long warning_id) {
        this.warning_id = warning_id;
    }

    public String getWarning_code() {
        return warning_code;
    }
    public void setWarning_code(String warning_code) {
        this.warning_code = warning_code;
    }

    public String getWarning_type() {
        return warning_type;
    }
    public void setWarning_type(String warning_type) {
        this.warning_type = warning_type;
    }

    public String getWarning_name() {
        return warning_name;
    }
    public void setWarning_name(String warning_name) {
        this.warning_name = warning_name;
    }

    public Long getBoat_id() {
        return boat_id;
    }
    public void setBoat_id(Long boat_id) {
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

    public Long getDevice_id() {
        return device_id;
    }
    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
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

    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getWarning_data_id() {
        return warning_data_id;
    }
    public void setWarning_data_id(String warning_data_id) {
        this.warning_data_id = warning_data_id;
    }

    public String getWarning_method() {
        return warning_method;
    }
    public void setWarning_method(String warning_method) {
        this.warning_method = warning_method;
    }

    public String getWarning_time() {
        return warning_time;
    }
    public void setWarning_time(String warning_time) {
        this.warning_time = warning_time;
    }

    public Integer getIs_deal() {
        return is_deal;
    }
    public void setIs_deal(Integer is_deal) {
        this.is_deal = is_deal;
    }

    public Integer getIs_delete() {
        return is_delete;
    }
    public void setIs_delete(Integer is_delete) {
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
