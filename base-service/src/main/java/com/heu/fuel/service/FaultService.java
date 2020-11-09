package com.heu.fuel.service;

import com.heu.fuel.entity.FaultRecordDatas;
import com.heu.fuel.entity.SensorDatas;

import java.util.List;

public interface FaultService {

    public int updateBoat(Integer FAULT_BOAT_COUNT, Float FAULT_BOAT_SCALE, int boat_id);
    public int updateDevice(Integer FAULT_DEVICE_COUNT, Float FAULT_DEVICE_SCALE, int device_id);
    public int updateMain(Integer FAULT_COUNT, Float FAULT_SCALE, int fault_id);
    public int GetBoatsFaultCount(int boat_id);
    public int GetDeviceFaultCount(int device_id);
    public int GetFaultCountById(int fault_id);
    public int Fault_total();
    public List<Integer> GetBoatsId();
    public List<Integer> GetDeviceId();
    public List<Integer> GetFaultId();
}
