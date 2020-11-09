package com.heu.fuel.service.impl;

import com.heu.fuel.dao.FaultDao;
import com.heu.fuel.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultServiceImpl implements FaultService {
    @Autowired
    FaultDao faultDao;

    @Override
    public int updateBoat(Integer FAULT_BOAT_COUNT, Float FAULT_BOAT_SCALE, int boat_id){
        return faultDao.updateBoat(FAULT_BOAT_COUNT,FAULT_BOAT_SCALE,boat_id);
    }

    @Override
    public int updateDevice(Integer FAULT_DEVICE_COUNT, Float FAULT_DEVICE_SCALE, int device_id){
        return faultDao.updateDevice(FAULT_DEVICE_COUNT,FAULT_DEVICE_SCALE,device_id);
    }

    @Override
    public int updateMain(Integer FAULT_COUNT, Float FAULT_SCALE, int fault_id){
        return faultDao.updateMain(FAULT_COUNT,FAULT_SCALE,fault_id);
    }

    @Override
    public int GetBoatsFaultCount(int boat_id){
        return faultDao.GetBoatsFaultCount(boat_id);
    }

    @Override
    public int GetDeviceFaultCount(int device_id){
        return faultDao.GetDeviceFaultCount(device_id);
    }

    @Override
    public int GetFaultCountById(int fault_id){
        return faultDao.GetFaultCountById(fault_id);
    }

    @Override
    public int Fault_total(){
        return faultDao.Fault_total();
    }

    @Override
    public List<Integer> GetBoatsId(){
        return faultDao.GetBoatsId();
    }

    @Override
    public List<Integer> GetDeviceId(){
        return faultDao.GetDeviceId();
    }

    @Override
    public List<Integer> GetFaultId(){
        return faultDao.GetFaultId();
    }
}
