package com.heu.fuel.entity;

public class BoatsFaultRank {
    public String fault_boat_name;
    public int fault_boat_count;

    public String getFault_boat_name() {
        return fault_boat_name;
    }

    public void setFault_boat_name(String fault_boat_name) {
        this.fault_boat_name = fault_boat_name;
    }

    public int getFault_boat_count() {
        return fault_boat_count;
    }

    public void setFault_boat_count(int fault_boat_count) {
        this.fault_boat_count = fault_boat_count;
    }
}
