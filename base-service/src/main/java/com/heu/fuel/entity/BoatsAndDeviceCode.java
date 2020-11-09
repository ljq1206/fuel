package com.heu.fuel.entity;

import lombok.Data;

import java.util.List;

@Data
public class BoatsAndDeviceCode {
    public String value;
    public String label;
    public List<DeviceListCode> children;

    @Override
    public String toString() {
        return "BoatsAndDevice [value=" + value + ", label=" + label + ", children=" + children + "]";
    }
}
