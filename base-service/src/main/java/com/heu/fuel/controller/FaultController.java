package com.heu.fuel.controller;


import com.heu.fuel.entity.*;
import com.heu.fuel.service.BoatsService;
import com.heu.fuel.service.FaultService;
import com.heu.fuel.service.impl.MyCustomizeErrorCode;
import com.heu.fuel.util.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Controller
@CrossOrigin
public class FaultController {
    @Autowired
    private FaultService faultService;
    @Autowired
    private BoatsService boatsService;
    //故障发生
    @PostMapping("add/Sensor")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> insertSensorData(){
        List<Integer> BoatsCount = faultService.GetBoatsId();//获取船只id
        List<Integer> DeviceCount = faultService.GetDeviceId();//获取设备id
        List<Integer> FaultCount = faultService.GetFaultId();//获取故障id
        //按日期更新
        for(int j=1;j<6;j++) {
            int FaultRecordTotal = boatsService.FaultRecordTotal(j);
            if(FaultRecordTotal==0) continue;
            //更新船只统计表
            for (int k : BoatsCount) {
                if(j==1){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(boatsService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_SEVEN(boatsService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_SEVEN((float)boatsService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateBoatStatic(fault_static);
                }
                if(j==2){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(boatsService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_MONTH(boatsService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_MONTH((float)boatsService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateBoatStatic(fault_static);
                }
                if(j==3){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(boatsService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_QUARTER(boatsService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_QUARTER((float)boatsService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateBoatStatic(fault_static);
                }
                if(j==4){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(boatsService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_YEAR(boatsService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_YEAR((float)boatsService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateBoatStatic(fault_static);
                }
                if(j==5){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(boatsService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_ALL(boatsService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_ALL((float)boatsService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateBoatStatic(fault_static);
                }
            }
            //更新设备统计表
            for(int k: DeviceCount){
                if(j==1){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(boatsService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_SEVEN(boatsService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_SEVEN((float)boatsService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateDeviceStatic(fault_static);
                }
                if(j==2){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(boatsService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_MONTH(boatsService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_MONTH((float)boatsService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateDeviceStatic(fault_static);
                }
                if(j==3){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(boatsService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_QUARTER(boatsService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_QUARTER((float)boatsService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateDeviceStatic(fault_static);
                }
                if(j==4){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(boatsService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_YEAR(boatsService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_YEAR((float)boatsService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateDeviceStatic(fault_static);
                }
                if(j==5){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(boatsService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_ALL(boatsService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_ALL((float)boatsService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    boatsService.updateDeviceStatic(fault_static);
                }
            }
            //更新故障统计表
            for(int k: FaultCount){
                if(j==1){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(boatsService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_SEVEN(boatsService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_SEVEN((float)boatsService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    boatsService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = boatsService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(boatsService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_SEVEN(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        boatsService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==2){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(boatsService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_MONTH(boatsService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_MONTH((float)boatsService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    boatsService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = boatsService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(boatsService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_MONTH(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_MONTH((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        boatsService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==3){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(boatsService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_QUARTER(boatsService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_QUARTER((float)boatsService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    boatsService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = boatsService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(boatsService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_QUARTER(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_QUARTER((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        boatsService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==4){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(boatsService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_YEAR(boatsService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_YEAR((float)boatsService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    boatsService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = boatsService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(boatsService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_YEAR(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_YEAR((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        boatsService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==5){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(boatsService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_ALL(boatsService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_ALL((float)boatsService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    boatsService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = boatsService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(boatsService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_ALL(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_ALL((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        boatsService.updateFaultStatic(fault_static1);
                    }
                }
            }
        }
        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(MyCustomizeErrorCode.ADD_BOAT_CORRECT,map);
    }

}
