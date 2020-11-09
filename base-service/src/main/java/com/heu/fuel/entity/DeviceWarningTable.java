package com.heu.fuel.entity;

public class DeviceWarningTable {
    private String id;
    private String device_code;
    private String device_name;
    private String boat_id;
    private String boat_code;
    private String boat_name;
    private Long warning_device_count;
    private Float warning_device_scale;

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

    public Long getWarning_device_count() {
        return warning_device_count;
    }

    public void setWarning_device_count(Long warning_device_count) {
        this.warning_device_count = warning_device_count;
    }

    public Float getWarning_device_scale() {
        return warning_device_scale;
    }

    public void setWarning_device_scale(Float warning_device_scale) {
        this.warning_device_scale = warning_device_scale;
    }
}
