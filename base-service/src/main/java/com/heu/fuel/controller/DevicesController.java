package com.heu.fuel.controller;


import com.heu.fuel.entity.*;
import com.heu.fuel.service.DeviceService;
import com.heu.fuel.service.FaultService;
import com.heu.fuel.service.LogService;
import com.heu.fuel.service.impl.MyCustomizeErrorCode;
import com.heu.fuel.util.CustomizeException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;
import static com.heu.fuel.service.impl.MyCustomizeErrorCode.INTRODUCTION_DATE_NOT_FOUND;

//提供restful服务
@RestController
@Controller
@CrossOrigin
public class DevicesController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private LogService logService;

    @Autowired
    private FaultService faultService;

    //设备当前状态
    @PostMapping("/base/api/get/device/today/status")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> FaultStatus(@RequestBody Datas datas){
        String device_code =datas.getDevice_code();
        Map<String, String> map1 = new HashMap<>(3);
        map1.put("current_status","正常");
        Map<String, String> map2 = new HashMap<>(3);
        map2.put("current_status","故障");
        Map<String, String> map3 = new HashMap<>(3);
        map3.put("current_status","预警");
        int b = deviceService.WarningStatus(device_code);
        int a = deviceService.FaultStatus(device_code);
        if (a != 0){return new CustomizeException<Map>(FIND_ALL_CORRECT,map2);}
        else if (b != 0){return new CustomizeException<Map>(FIND_ALL_CORRECT,map3);}
        return new CustomizeException<Map>(FIND_ALL_CORRECT,map1);
    }

    //某设备当前发生故障名称列表
    @PostMapping("/base/api/get/device/notdealList")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> NotdealList(@RequestBody Datas datas){
        String device_code =datas.getDevice_code();
        Map<String, Set> map = new HashMap<>(3);
        map.put("notdealList",deviceService.GetNotDealList(device_code));
        return new CustomizeException<Map>(FIND_ALL_CORRECT,map);
    }

    //获取此设备预防性维护状态
    @PostMapping("/base/api/get/device/prevent")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> PreventStatus(@RequestBody Datas datas){
        String device_code =datas.getDevice_code();
        Map<String, String> map1 = new HashMap<>(3);
        map1.put("current_status","正常");
        Map<String, String> map3 = new HashMap<>(3);
        map3.put("current_status","预警");
        int a = deviceService.PreventStatus(device_code);
        if (a != 0){return new CustomizeException<Map>(FIND_ALL_CORRECT,map3);}
        else return new CustomizeException<Map>(FIND_ALL_CORRECT,map1);
    }

    //获取此设备备品备件状态
    @PostMapping("/base/api/get/device/sparepart")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> SparepartStatus(@RequestBody Datas datas){
        String device_code =datas.getDevice_code();
        Map<String, String> map1 = new HashMap<>(3);
        map1.put("current_status","正常");
        Map<String, String> map3 = new HashMap<>(3);
        map3.put("current_status","预警");
        int a = deviceService.SparepartStatus(device_code);
        if (a != 0){return new CustomizeException<Map>(FIND_ALL_CORRECT,map3);}
        else return new CustomizeException<Map>(FIND_ALL_CORRECT,map1);
    }

    //设备故障排行
    @PostMapping("/base/api/get/device/fault/rank")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> BoatsFaultRank(@RequestBody Datas datas){
        Integer date =datas.getDate();
        if(datas.getDate()==null) date=1;
        List<Integer> a = deviceService.GetDeviceId();
        if(a.size()==0) return new CustomizeException<>(FIND_ALL_CORRECT,new HashMap<>());
        else {
            List<LinkedHashMap<String, Object>> arr = new ArrayList<>();
            for (int i : a) {
                LinkedHashMap<String, Object> map = new LinkedHashMap<>(2);
                map.put("fault_device_name", deviceService.GetDeviceName(i));
                map.put("fault_device_count", deviceService.GetDeviceFaultCount(i, date));
                arr.add(map);
            }
            Collections.sort(arr, new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    Integer o1Value = Integer.parseInt(o1.get("fault_device_count").toString());
                    Integer o2Value = Integer.parseInt(o2.get("fault_device_count").toString());
                    return o2Value.compareTo(o1Value);
                }
            });
            if (arr.size() > 5) {
                List<LinkedHashMap<String, Object>> arr1 = new ArrayList<>();
                arr1 = arr.subList(0, 5);
                Collections.reverse(arr1);
                LinkedHashMap<String, Object> map = new LinkedHashMap<>(3);
                map.put("DevicesFaultRank", arr1);
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            } else {
                Collections.reverse(arr);
                LinkedHashMap<String, Object> map = new LinkedHashMap<>(3);
                map.put("DevicesFaultRank", arr);
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
    }

    //设备预警排名
    @PostMapping("/base/api/get/device/warning/rank")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> BoatsWarningRank(@RequestBody Datas datas){
        Integer date =datas.getDate();
        if(datas.getDate()==null) date=1;
        List<Integer> a = deviceService.GetDeviceId();
        if(a.size()==0) return new CustomizeException<>(FIND_ALL_CORRECT,new HashMap<>());
        else {
            List<LinkedHashMap<String, Object>> arr = new ArrayList<>();
            for (int i : a) {
                LinkedHashMap<String, Object> map = new LinkedHashMap<>(2);
                map.put("warning_device_name", deviceService.GetDeviceName(i));
                map.put("warning_device_count", deviceService.GetDeviceWarningCount(i, date));
                arr.add(map);
            }
            Collections.sort(arr, new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    Integer o1Value = Integer.parseInt(o1.get("warning_device_count").toString());
                    Integer o2Value = Integer.parseInt(o2.get("warning_device_count").toString());
                    return o2Value.compareTo(o1Value);
                }
            });
            if (arr.size() > 5) {
                List<LinkedHashMap<String, Object>> arr1 = new ArrayList<>();
                arr1 = arr.subList(0, 5);
                Collections.reverse(arr1);
                LinkedHashMap<String, Object> map = new LinkedHashMap<>(3);
                map.put("DevicesWarningRank", arr1);
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            } else {
                Collections.reverse(arr);
                LinkedHashMap<String, Object> map = new LinkedHashMap<>(3);
                map.put("DevicesWarningRank", arr);
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
    }


    //查看设备信息
    @PostMapping("/base/api/get/device/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody Datas datas){

        Map<String, Object> map = new HashMap<>(3);
        map.put("deviceList", deviceService.queryAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }
    //查看设备故障统计信息—表格
    @PostMapping("/base/api/get/fault/device/statistics/information/table")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryFaultTable(@RequestBody Datas datas){
        String Find_key =datas.getFind_key();
        String Sort_key =datas.getSort_key();
        if (!(datas.getDate()==null||datas.getDate()==1||datas.getDate()==2||datas.getDate()==3||datas.getDate()==4||datas.getDate()==5)){
            Map<String, String> map = new HashMap<>(3);
            return new CustomizeException<>(INTRODUCTION_DATE_NOT_FOUND, map);
        }
        if(datas.getFind_key()!=null&&datas.getSort_key()!=null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_SEVEN";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_SEVEN";
                }
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_SEVEN";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_MONTH";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_MONTH";
                }
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_MONTH";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_QUARTER";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_QUARTER";
                }
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_QUARTER";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_YEAR";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_YEAR";
                }
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_YEAR";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_ALL";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_ALL";
                }
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_ALL";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_ALL";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()!=null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_SEVEN";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_MONTH";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_QUARTER";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_YEAR";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getFind_key().equals("fault_scale")) {
                    Find_key = "FAULT_SCALE_ALL";
                }
                if (datas.getFind_key().equals("fault_count")) {
                    Find_key = "FAULT_COUNT_ALL";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()!=null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_SEVEN";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_MONTH";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_QUARTER";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_YEAR";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_ALL";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_ALL";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }
    //查看设备预警统计信息—表格
    @PostMapping("/base/api/get/warning/device/statistics/information/table")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryWarningTable(@RequestBody Datas datas){
        String Find_key =datas.getFind_key();
        String Sort_key =datas.getSort_key();
        if (!(datas.getDate()==null||datas.getDate()==1||datas.getDate()==2||datas.getDate()==3||datas.getDate()==4||datas.getDate()==5)){
            Map<String, String> map = new HashMap<>(3);
            return new CustomizeException<>(INTRODUCTION_DATE_NOT_FOUND, map);
        }
        if(datas.getFind_key()!=null&&datas.getSort_key()!=null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_SEVEN";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_SEVEN";
                }
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_SEVEN";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_MONTH";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_MONTH";
                }
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_MONTH";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_QUARTER";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_QUARTER";
                }
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_QUARTER";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_YEAR";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_YEAR";
                }
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_YEAR";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_All";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_All";
                }
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_All";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_All";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()!=null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_SEVEN";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_MONTH";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_QUARTER";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_YEAR";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_All";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_All";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()!=null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_SEVEN";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_MONTH";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_QUARTER";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_YEAR";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getSort_key().equals("warning_scale")) {
                    Sort_key = "WARNING_SCALE_All";
                }
                if (datas.getSort_key().equals("warning_count")) {
                    Sort_key = "WARNING_COUNT_All";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("deviceList", deviceService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }
    //    添加
    @PostMapping("/base/api/device/add")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> insertBoat(@RequestBody Device device){
        if(deviceService.isExist(device)!=0) {
            return new CustomizeException<>(MyCustomizeErrorCode.INSERT_DEVICE_REPEAT_DATA, new HashMap<>());
        }
        else {
            deviceService.insertDevice(device);
            deviceService.updateDeviceByBoat();
            deviceService.updatePartByDevice();
            deviceService.updatePreventByDevice();
            DeviceStatic deviceStatic = new DeviceStatic();
            deviceStatic.setBoat_id(device.getBoat_id());
            deviceStatic.setDevice_id(device.getId());
            deviceStatic.setDevice_code(device.getDevice_code());
            deviceStatic.setDevice_name(device.getDevice_name());
            deviceStatic.setFAULT_SCALE_SEVEN((float) 0.0);
            deviceStatic.setFAULT_SCALE_MONTH((float) 0.0);
            deviceStatic.setFAULT_SCALE_QUARTER((float) 0.0);
            deviceStatic.setFAULT_SCALE_YEAR((float) 0.0);
            deviceStatic.setFAULT_SCALE_ALL((float) 0.0);
            deviceStatic.setWARNING_SCALE_SEVEN((float) 0.0);
            deviceStatic.setWARNING_SCALE_MONTH((float) 0.0);
            deviceStatic.setWARNING_SCALE_QUARTER((float) 0.0);
            deviceStatic.setWARNING_SCALE_YEAR((float) 0.0);
            deviceStatic.setWARNING_SCALE_ALL((float) 0.0);
            deviceService.insertDeviceStatic(deviceStatic);  //添加设备统计表
            deviceService.updateDeviceSByDevice();
            Map<String, Object> map = new HashMap<>(3);
            map.put("device_id", device.getId());
            return new CustomizeException<>(MyCustomizeErrorCode.ADD_BOAT_CORRECT, map);
        }
    }

    //    更新
    @PostMapping("/base/api/device/update")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> updateDevice(@RequestBody Device device){
        if(deviceService.isExist(device)!=0) {
            return new CustomizeException<>(MyCustomizeErrorCode.INSERT_DEVICE_REPEAT_DATA, new HashMap<>());
        }
        else {
            deviceService.updateDevice(device);
            deviceService.updateDeviceByBoat();
            deviceService.updateDataByDevice();
            deviceService.updateFaultRecordByDevice();
            deviceService.updateWarningRecordByDevice();
            deviceService.updatePreventByDevice();
            deviceService.updatePreventRecordByDevice();
            deviceService.updatePartByDevice();
            deviceService.updatePartChangeByDevice();
            deviceService.updatePartWarningByDevice();
            deviceService.updatePartInoutByDevice();
            deviceService.updateDeviceSByDevice();
            Map<String, Object> map = new HashMap<>(3);

            return new CustomizeException<>(MyCustomizeErrorCode.UPDATE_BOAT_CORRECT, map);
        }
    }
    //删除 、 批量删除
    @PostMapping("/base/api/device/delete")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> deleteDevice(@RequestBody Datas datas){
        String[] arr = datas.getDevice_id().replace("\"", "").split(",");
        deviceService.deleteDevice(arr);
        deviceService.deleteDataByDevice();
        deviceService.deleteFaultRecordByDevice();
        deviceService.deleteWarningRecordByDevice();
        deviceService.deletePreventByDevice();
        deviceService.deletePreventRecordByDevice();
        deviceService.deletePartByDevice();
        deviceService.deletePartChangeByDevice();
        deviceService.deletePartWarningByDevice();
        deviceService.deletePartInoutByDevice();
        deviceService.deleteDeviceSByDevice();
        List<Integer> BoatsCount = faultService.GetBoatsId();//获取船只id
        List<Integer> DeviceCount = faultService.GetDeviceId();//获取设备id
        List<Integer> FaultCount = faultService.GetFaultId();//获取故障id
        //按日期更新
        for(int j=1;j<6;j++) {
            int FaultRecordTotal = deviceService.FaultRecordTotal(j);
            if(FaultRecordTotal==0) continue;
            //更新船只统计表
            for (int k : BoatsCount) {
                if(j==1){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(deviceService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_SEVEN(deviceService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_SEVEN((float)deviceService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateBoatStatic(fault_static);
                }
                if(j==2){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(deviceService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_MONTH(deviceService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_MONTH((float)deviceService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateBoatStatic(fault_static);
                }
                if(j==3){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(deviceService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_QUARTER(deviceService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_QUARTER((float)deviceService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateBoatStatic(fault_static);
                }
                if(j==4){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(deviceService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_YEAR(deviceService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_YEAR((float)deviceService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateBoatStatic(fault_static);
                }
                if(j==5){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setBoat_id(k);
                    if(deviceService.GetBoatsFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_ALL(deviceService.GetBoatsFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_ALL((float)deviceService.GetBoatsFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateBoatStatic(fault_static);
                }
            }
            //更新设备统计表
            for(int k: DeviceCount){
                if(j==1){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(deviceService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_SEVEN(deviceService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_SEVEN((float)deviceService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateDeviceStatic(fault_static);
                }
                if(j==2){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(deviceService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_MONTH(deviceService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_MONTH((float)deviceService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateDeviceStatic(fault_static);
                }
                if(j==3){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(deviceService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_QUARTER(deviceService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_QUARTER((float)deviceService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateDeviceStatic(fault_static);
                }
                if(j==4){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(deviceService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_YEAR(deviceService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_YEAR((float)deviceService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateDeviceStatic(fault_static);
                }
                if(j==5){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setDevice_id(k);
                    if(deviceService.GetDeviceFaultRecordCount(k,j)==0) continue;
                    fault_static.setFAULT_COUNT_ALL(deviceService.GetDeviceFaultRecordCount(k,j));
                    fault_static.setFAULT_SCALE_ALL((float)deviceService.GetDeviceFaultRecordCount(k,j)/FaultRecordTotal);
                    deviceService.updateDeviceStatic(fault_static);
                }
            }
            //更新故障统计表
            for(int k: FaultCount){
                if(j==1){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(deviceService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_SEVEN(deviceService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_SEVEN((float)deviceService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    deviceService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = deviceService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(deviceService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_SEVEN(deviceService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)deviceService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        deviceService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==2){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(deviceService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_MONTH(deviceService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_MONTH((float)deviceService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    deviceService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = deviceService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(deviceService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_SEVEN(deviceService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)deviceService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        deviceService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==3){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(deviceService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_QUARTER(deviceService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_QUARTER((float)deviceService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    deviceService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = deviceService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(deviceService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_SEVEN(deviceService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)deviceService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        deviceService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==4){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(deviceService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_YEAR(deviceService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_YEAR((float)deviceService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    deviceService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = deviceService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(deviceService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_SEVEN(deviceService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)deviceService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        deviceService.updateFaultStatic(fault_static1);
                    }
                }
                if(j==5){
                    Fault_static fault_static =new Fault_static();
                    fault_static.setFault_id(k);
                    if(deviceService.GetFaultRecordCountById(k,j)==0) continue;
                    fault_static.setBoat_id(0);
                    fault_static.setFAULT_COUNT_ALL(deviceService.GetFaultRecordCountById(k,j));
                    fault_static.setFAULT_SCALE_ALL((float)deviceService.GetFaultRecordCountById(k,j)/FaultRecordTotal);
                    deviceService.updateFaultStatic(fault_static);
                    for(int p:BoatsCount) {
                        int FaultRecordTotalByBoats = deviceService.FaultRecordTotal1(j,p);
                        Fault_static fault_static1 =new Fault_static();
                        fault_static1.setFault_id(k);
                        if(deviceService.GetFaultRecordCountById1(k,j,p)==0) continue;
                        fault_static1.setBoat_id(p);
                        fault_static1.setFAULT_COUNT_SEVEN(deviceService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)deviceService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        deviceService.updateFaultStatic(fault_static1);
                    }
                }
            }
        }

        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(MyCustomizeErrorCode.DELETE_BOAT_CORRECT, map);
    }
    //    删除全部
    @PostMapping("/base/api/device/delete/all")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> deleteAll() {
        deviceService.deleteAll();
        Map<String, Object> map = new HashMap<>(3);

        //系统日志
        LogActivity logActivity = new LogActivity();
        logActivity.setLog_name("admin");
        logActivity.setDescription("删除所有设备");
        logService.insertLog(logActivity);

        return new CustomizeException<>(MyCustomizeErrorCode.DELETE_BOAT_CORRECT, map);
    }
    //
}
