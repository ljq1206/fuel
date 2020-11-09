package com.heu.fuel.entity;

public class MainKnowledgeDatasTable {
    private String id;
    private String fault_code;
    private String fault_name;
    private Long fault_count;
    private Float fault_scale;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFault_code() {
        return fault_code;
    }

    public void setFault_code(String fault_code) {
        this.fault_code = fault_code;
    }

    public String getFault_name() {
        return fault_name;
    }

    public void setFault_name(String fault_name) {
        this.fault_name = fault_name;
    }

    public Long getFault_count() {
        return fault_count;
    }

    public void setFault_count(Long fault_count) {
        this.fault_count = fault_count;
    }

    public Float getFault_scale() {
        return fault_scale;
    }

    public void setFault_scale(Float fault_scale) {
        this.fault_scale = fault_scale;
    }
}
