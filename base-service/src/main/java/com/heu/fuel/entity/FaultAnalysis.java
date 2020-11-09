package com.heu.fuel.entity;

public class FaultAnalysis {
    public String fault_name;
    public int fault_count;
    public float fault_scale;

    public String getFault_name() {
        return fault_name;
    }

    public void setFault_name(String fault_name) {
        this.fault_name = fault_name;
    }

    public int getFault_count() {
        return fault_count;
    }

    public void setFault_count(int fault_count) {
        this.fault_count = fault_count;
    }

    public float getFault_scale() {
        return fault_scale;
    }

    public void setFault_scale(float fault_scale) {
        this.fault_scale = fault_scale;
    }
}
