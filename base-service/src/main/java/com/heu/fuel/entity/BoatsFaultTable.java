package com.heu.fuel.entity;

public class BoatsFaultTable {
    private String id; //主键  自增
    private String boat_code; //船的代码
    private String boat_name; //船的名字
    private Long fault_boat_count; //错误总数
    private Float fault_boat_scale; //错误百分比

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

    public Long getFault_boat_count() {
        return fault_boat_count;
    }

    public void setFault_boat_count(Long fault_boat_count) {
        this.fault_boat_count = fault_boat_count;
    }

    public Float getFault_boat_scale() {
        return fault_boat_scale;
    }

    public void setFault_boat_scale(Float fault_boat_scale) {
        this.fault_boat_scale = fault_boat_scale;
    }
}
