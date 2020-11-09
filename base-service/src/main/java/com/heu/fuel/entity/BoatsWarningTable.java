package com.heu.fuel.entity;

public class BoatsWarningTable {
    private String id; //主键  自增
    private String boat_code; //船的代码
    private String boat_name; //船的名字
    private Long warning_boat_count; //警告数
    private Float warning_boat_scale; //警告百分比

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

    public Long getWarning_boat_count() {
        return warning_boat_count;
    }

    public void setWarning_boat_count(Long warning_boat_count) {
        this.warning_boat_count = warning_boat_count;
    }

    public Float getWarning_boat_scale() {
        return warning_boat_scale;
    }

    public void setWarning_boat_scale(Float warning_boat_scale) {
        this.warning_boat_scale = warning_boat_scale;
    }
}
