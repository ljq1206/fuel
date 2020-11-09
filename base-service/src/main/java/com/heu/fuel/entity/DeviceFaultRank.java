package com.heu.fuel.entity;

import java.io.Serializable;

public class DeviceFaultRank implements Serializable {
    public String fault_device_name;
    public int fault_device_count;

    public String getFault_device_name() {
        return fault_device_name;
    }

    public void setFault_device_name(String fault_device_name) {
        this.fault_device_name = fault_device_name;
    }

    public int getFault_device_count() {
        return fault_device_count;
    }

    public void setFault_device_count(int fault_device_count) {
        this.fault_device_count = fault_device_count;
    }
}
