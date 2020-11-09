package com.heu.fuel.entity;

public class BoatsList {
    private String id; //主键  自增
    private String boat_code; //船的代码
    private String boat_name; //船的名字

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
}
