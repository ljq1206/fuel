package com.heu.fuel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参
@Accessors(chain = true) //表示支持链式写法
public class LogActivity implements Serializable {
    public Long id;
    public String log_name;
    public String description;
    public int is_delete;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLog_name() {
        return log_name;
    }
    public void setLog_name(String log_name) {
        this.log_name = log_name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
