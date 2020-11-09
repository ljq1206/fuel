package com.heu.fuel.controller;

import com.heu.fuel.entity.*;
import com.heu.fuel.service.BoatsService;
import com.heu.fuel.service.FaultService;
import com.heu.fuel.service.LogService;
import com.heu.fuel.service.impl.MyCustomizeErrorCode;
import com.heu.fuel.util.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;
import static com.heu.fuel.service.impl.MyCustomizeErrorCode.*;

//6. 写完resource文件夹中的mapper.xml 然后最后写控制
//提供restful服务
@RestController
@Controller
@CrossOrigin
public class BoatsController {
    @Autowired
    private BoatsService boatsService;

    @Autowired
    private LogService logService;

    @Autowired
    private FaultService faultService;

    @PostMapping("/base/api/get/boat/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody Datas datas){
        Map<String, Object> map = new HashMap<>(3);
        map.put("boatList", boatsService.queryAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //查看船只故障统计信息——表格
    @PostMapping("/base/api/get/fault/boat/statistics/information")
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
                map.put("boatList", boatsService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //查看船只预警统计信息——表格
    @PostMapping("/base/api/get/warning/boat/statistics/information")
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
                map.put("boatList", boatsService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {

                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
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
                map.put("boatList", boatsService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()!=null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_SEVEN";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_MONTH";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_MONTH";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_QUARTER";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_QUARTER";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_YEAR";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_YEAR";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                if (datas.getFind_key().equals("warning_scale")) {
                    Find_key = "WARNING_SCALE_All";
                }
                if (datas.getFind_key().equals("warning_count")) {
                    Find_key = "WARNING_COUNT_All";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("boatList", boatsService.queryWarningTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),datas.getBoat_id()));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //获取船只list
    @GetMapping("/base/api/get/device/boat/list")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> boatsList(){
        Map<String, Object> map = new HashMap<>(3);
        map.put("boatList", boatsService.boatsList());
        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }

    //获取列表(获取id-name列表)
    @GetMapping("/base/api/get/boat/list")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> GetBoatList(){
        Map<String, Object> map = new HashMap<>(3);
        map.put("boatList", boatsService.GetBoatList());
        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }
    //获取列表(获取code-name列表)
    @GetMapping("/base/api/get/boat/codelist")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> GetBoatCodeList(){
        Map<String, Object> map = new HashMap<>(3);
        map.put("boatList", boatsService.GetBoatListCode());
        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }

    //船只故障排名
    @PostMapping("/base/api/get/boat/fault/rank")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> BoatsFaultRank(@RequestBody(required = false) Datas datas){
       Integer date =datas.getDate();
       if(date==null) date=1;
       List<Integer> a = boatsService.GetBoatId();
       if(a.size()==0) return new CustomizeException<>(FIND_ALL_CORRECT,new HashMap<>());
       else {
           List<Map<String, Object>> arr = new ArrayList<Map<String, Object>>();
           for (int i : a) {
               Map<String, Object> map = new HashMap<>(2);
               map.put("fault_boat_name", boatsService.GetBoatName(i));
               map.put("fault_boat_count", boatsService.GetBoatsFaultCount(i, date));
               arr.add(map);
           }
           Collections.sort(arr, new Comparator<Map<String, Object>>() {
               @Override
               public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                   Integer o1Value = Integer.parseInt(o1.get("fault_boat_count").toString());
                   Integer o2Value = Integer.parseInt(o2.get("fault_boat_count").toString());
                   return o2Value.compareTo(o1Value);
               }
           });
           if (arr.size() > 5) {
               List<Map<String, Object>> arr1 = new ArrayList<Map<String, Object>>();
               arr1 = arr.subList(0, 5);
               Collections.reverse(arr1);
               Map<String, Object> map = new HashMap<>(3);
               map.put("BoatsFaultRank", arr1);
               return new CustomizeException<>(FIND_ALL_CORRECT, map);
           } else {
               Collections.reverse(arr);
               Map<String, Object> map = new HashMap<>(3);
               map.put("BoatsFaultRank", arr);
               return new CustomizeException<>(FIND_ALL_CORRECT, map);
           }
       }
    }

    //船只预警排名
    @PostMapping("/base/api/get/boat/warning/rank")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> BoatsWarningRank(@RequestBody Datas datas){
        Integer date =datas.getDate();
        if(datas.getDate()==null) date=1;
        List<Integer> a = boatsService.GetBoatId();
        if(a.size()==0) return new CustomizeException<>(FIND_ALL_CORRECT,new HashMap<>());
        else {
            List<Map<String, Object>> arr = new ArrayList<Map<String, Object>>();
            for (int i : a) {
                Map<String, Object> map = new HashMap<>(2);
                map.put("warning_boat_name", boatsService.GetBoatName(i));
                map.put("warning_boat_count", boatsService.GetBoatsWarningCount(i, date));
                arr.add(map);
            }
            Collections.sort(arr, new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    Integer o1Value = Integer.parseInt(o1.get("warning_boat_count").toString());
                    Integer o2Value = Integer.parseInt(o2.get("warning_boat_count").toString());
                    return o2Value.compareTo(o1Value);
                }
            });
            if (arr.size() > 5) {
                List<Map<String, Object>> arr1 = new ArrayList<Map<String, Object>>();
                arr1 = arr.subList(0, 5);
                Collections.reverse(arr1);
                Map<String, Object> map = new HashMap<>(3);
                map.put("BoatsWarningRank", arr1);
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            } else {
                Collections.reverse(arr);
                Map<String, Object> map = new HashMap<>(3);
                map.put("BoatsWarningRank", arr);
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
    }

    //    添加
    @PostMapping("/base/api/boat/add")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> insertBoat(@RequestBody Boats boats){
        if(boatsService.isExist(boats)!=0) {
            return new CustomizeException<>(MyCustomizeErrorCode.INSERT_BOAT_REPEAT_DATA, new HashMap<>());
        }
        else {
            boatsService.insertBoat(boats);
            BoatsStatic boatsStatic = new BoatsStatic();
            boatsStatic.setBoat_id(boats.getId());
            boatsStatic.setBoat_code(boats.getBoat_code());
            boatsStatic.setBoat_name(boats.getBoat_name());
            boatsStatic.setFAULT_SCALE_ALL((float) 0.0);
            boatsStatic.setFAULT_SCALE_SEVEN((float) 0.0);
            boatsStatic.setFAULT_SCALE_MONTH((float) 0.0);
            boatsStatic.setFAULT_SCALE_QUARTER((float) 0.0);
            boatsStatic.setFAULT_SCALE_YEAR((float) 0.0);
            boatsStatic.setWARNING_SCALE_ALL((float) 0.0);
            boatsStatic.setWARNING_SCALE_SEVEN((float) 0.0);
            boatsStatic.setWARNING_SCALE_MONTH((float) 0.0);
            boatsStatic.setWARNING_SCALE_QUARTER((float) 0.0);
            boatsStatic.setWARNING_SCALE_YEAR((float) 0.0);
            boatsService.insertBoatStatic(boatsStatic);
            List<Integer> fault_id =boatsService.GetFaultId();
            for(int i:fault_id){
                FaultStatic faultStatic = new FaultStatic();
                faultStatic.setFault_id(i);
                faultStatic.setBoat_id(boats.getId());
                faultStatic.setFAULT_SCALE_ALL((float) 0.0);
                faultStatic.setFAULT_SCALE_SEVEN((float) 0.0);
                faultStatic.setFAULT_SCALE_MONTH((float) 0.0);
                faultStatic.setFAULT_SCALE_QUARTER((float) 0.0);
                faultStatic.setFAULT_SCALE_YEAR((float) 0.0);
                boatsService.insertFaultStatic(faultStatic);
            }
            boatsService.updateFaultStaticByMain();
            Map<String, Object> map = new HashMap<>(3);
            map.put("boat_id", boats.getId());
            return new CustomizeException<>(MyCustomizeErrorCode.ADD_BOAT_CORRECT, map);
        }
    }

//    更新
    @PostMapping("/base/api/boat/update")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> updateBoat(@RequestBody Boats boats){
        if(boatsService.isExist(boats)!=0) {
            return new CustomizeException<>(MyCustomizeErrorCode.INSERT_BOAT_REPEAT_DATA, new HashMap<>());
        }
        else {
            boatsService.updateBoat(boats);
            boatsService.updateDeviceByBoat();
            boatsService.updateDataByBoat();
            boatsService.updateFaultRecordByBoat();
            boatsService.updateWarningRecordByBoat();
            boatsService.updatePreventByBoat();
            boatsService.updatePreventRecordByBoat();
            boatsService.updatePartByBoat();
            boatsService.updatePartChangeByBoat();
            boatsService.updatePartWarningByBoat();
            boatsService.updatePartInoutByBoat();
            boatsService.updateBoatSByBoat();
            boatsService.updateDeviceSByBoat();
            Map<String, Object> map = new HashMap<>(3);
            return new CustomizeException(MyCustomizeErrorCode.UPDATE_BOAT_CORRECT, map);
        }
    }

    //    删除 批量删除
    @PostMapping("/base/api/boat/delete")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> deleteBoat(@RequestBody Datas datas) {
        String Id = datas.getId();
        List<String> arr = Arrays.asList(Id.split(","));
        boatsService.deleteBoat(arr);
        boatsService.deleteDeviceByBoat();
        boatsService.deleteDataByBoat();
        boatsService.deleteFaultRecordByBoat();
        boatsService.deleteWarningRecordByBoat();
        boatsService.deletePreventByBoat();
        boatsService.deletePreventRecordByBoat();
        boatsService.deletePartByBoat();
        boatsService.deletePartChangeByBoat();
        boatsService.deletePartWarningByBoat();
        boatsService.deletePartInoutByBoat();
        boatsService.deleteBoatSByBoat();
        boatsService.deleteDeviceSByBoat();
        boatsService.deleteFaultSByBoat();
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
                        fault_static1.setFAULT_COUNT_SEVEN(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
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
                        fault_static1.setFAULT_COUNT_SEVEN(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
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
                        fault_static1.setFAULT_COUNT_SEVEN(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
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
                        fault_static1.setFAULT_COUNT_SEVEN(boatsService.GetFaultRecordCountById1(k,j,p));
                        fault_static1.setFAULT_SCALE_SEVEN((float)boatsService.GetFaultRecordCountById1(k,j,p)/FaultRecordTotalByBoats);
                        boatsService.updateFaultStatic(fault_static1);
                    }
                }
            }
        }

        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException(MyCustomizeErrorCode.DELETE_BOAT_CORRECT, map);
    }




    //    删除全部
    @PostMapping("/base/api/boat/delete/all")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> deleteAll() {
        boatsService.deleteAll();
        Map<String, Object> map = new HashMap<>(3);

        //系统日志
        LogActivity logActivity = new LogActivity();
        logActivity.setLog_name("admin");
        logActivity.setDescription("删除所有船只");
        logService.insertLog(logActivity);

        return new CustomizeException(MyCustomizeErrorCode.DELETE_BOAT_CORRECT, map);
    }
}
