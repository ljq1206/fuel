package com.heu.fuel.controller;

import com.alibaba.fastjson.JSONObject;
import com.heu.fuel.entity.*;
import com.heu.fuel.service.LogService;
import com.heu.fuel.service.MainKnowledgeDatasService;
import com.heu.fuel.util.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.*;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.*;

//提供restful服务
@RestController
@Controller
@CrossOrigin
public class MainKnowledgeDatasController {

    @Autowired
    private MainKnowledgeDatasService mainKnowledgeDatasService;

    @Autowired
    private LogService logService;

    @PostMapping("/base/api/get/manual/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody Datas datas){

        Map<String, Object> map = new HashMap<>(3);
        map.put("manualList", mainKnowledgeDatasService.queryAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);

    }
    //查看故障类型统计信息—表格
    @PostMapping("/base/api/get/fault/type/statistics/information/table")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryTable(@RequestBody Datas datas){
        String boat_id =datas.getBoat_id();
        if(datas.getBoat_id()==null) boat_id="0";
        String Find_key =datas.getFind_key();
        String Sort_key =datas.getSort_key();
        if (!(datas.getDate()==null||datas.getDate()==1||datas.getDate()==2||datas.getDate()==3||datas.getDate()==4||datas.getDate()==5)){
            Map<String, String> map = new HashMap<>(3);
            return new CustomizeException<>(INTRODUCTION_DATE_NOT_FOUND, map);
        }
        if(datas.getFind_key()!=null&&datas.getSort_key()!=null){
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()==null) {
            if (datas.getDate() == null || datas.getDate() == 1) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableSeven(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 2) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableMonth(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 3) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableQuarter(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 4) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableYear(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
            if (datas.getDate() == 5) {
                Map<String, Object> map = new HashMap<>(3);
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableAll(Find_key, datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
                return new CustomizeException<>(FIND_ALL_CORRECT, map);
            }
        }
        if(datas.getFind_key()==null&&datas.getSort_key()!=null){
            if (datas.getDate() == null || datas.getDate() == 1) {
                if (datas.getSort_key().equals("fault_scale")) {
                    Sort_key = "FAULT_SCALE_SEVEN";
                }
                if (datas.getSort_key().equals("fault_count")) {
                    Sort_key = "FAULT_COUNT_SEVEN";
                }
                Map<String, Object> map = new HashMap<>(3);
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableSeven(datas.getFind_key(), datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableMonth(datas.getFind_key(), datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableQuarter(datas.getFind_key(), datas.getFind_value(), Sort_key, datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableYear(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
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
                map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableSeven(Find_key, datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
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
                    map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableMonth(Find_key, datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
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
                    map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableQuarter(Find_key, datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
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
                    map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableYear(Find_key, datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
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
                    map.put("faultTypeStatisticsList", mainKnowledgeDatasService.queryFaultTableAll(Find_key, datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),boat_id));
                    return new CustomizeException<>(FIND_ALL_CORRECT, map);
                }
        }
        Map<String, Object> map = new HashMap<>(3);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //根据fault_id 获取故障模型库优化信息
    @GetMapping("/base/api/get/fault/optimization/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> mainOptimizationFind(){
//        String[] fault_Id =datas.getFault_id().replace("\"","").split(",");
        Map<String, Object> map = new HashMap<>(3);
        map.put("faultoOtimizationInformation", mainKnowledgeDatasService.mainOptimizationFind());
        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }

    //确定故障优化
    @PostMapping("/base/api/agree/fault/optimization")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> updateMainKnowledgeDatas(@RequestBody UpdateMainKnowledgeDatas updateMainKnowledgeDatas){
        mainKnowledgeDatasService.updateFaultRecordByMain();
        Map<String,Object> map = new HashMap<>(3);
        mainKnowledgeDatasService.updateMainKnowledgeDatas(updateMainKnowledgeDatas);

        //系统日志
        LogActivity logActivity = new LogActivity();
        logActivity.setLog_name("admin");
        logActivity.setDescription("确认优化，id号："+ updateMainKnowledgeDatas.getFault_id());
        logService.insertLog(logActivity);

        return new CustomizeException<>(OPERATION_THIS_CORRECT,map);
    }

    //取消故障优化 即将is_main=0的加入知识库设为is_main=1
    @PostMapping("/base/api/not/agree/fault/optimization")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> updateMainOptimization(@RequestBody DatasId datasId){
        mainKnowledgeDatasService.updateFaultRecordByMain();
        Map<String,Object> map = new HashMap<>(3);
        mainKnowledgeDatasService.updateMainOptimization(datasId.getFault_id());

        //系统日志
        LogActivity logActivity = new LogActivity();
        logActivity.setLog_name("admin");
        logActivity.setDescription("取消优化，id号："+ datasId.getFault_id());
        logService.insertLog(logActivity);

        return new CustomizeException<>(OPERATION_THIS_CORRECT,map);
    }

    //故障分析
    @PostMapping("/base/api/get/fault/type/analysis")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> FaultAnalysis(@RequestBody Datas datas ){
        Integer date = datas.getDate();
        List<Integer> total = mainKnowledgeDatasService.GetFaultId();
        int a = mainKnowledgeDatasService.GetFaultCount(date,null);
        List<LinkedHashMap<String, Object>> arr = new ArrayList<>();
        for(int i:total){
            LinkedHashMap<String, Object> map = new LinkedHashMap<>(3);
            map.put("fault_name",mainKnowledgeDatasService.GetFaultName(i));
            map.put("fault_count",mainKnowledgeDatasService.GetFaultCountById(i,date,null));
            if (a !=0){
            map.put("fault_scale",(float)mainKnowledgeDatasService.GetFaultCountById(i,date,null)/a);}
            else map.put("fault_scale",0.0);
            arr.add(map);
        }
        Collections.sort(arr, new Comparator<Map<String,Object>>(){
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer o1Value = Integer.parseInt(o1.get("fault_count").toString());
                Integer o2Value = Integer.parseInt(o2.get("fault_count").toString());
                return o2Value.compareTo(o1Value);
            }
        });
        List<LinkedHashMap<String, Object>> arr1 = new ArrayList<>();
        arr1 =arr.subList(0,4);
        int c = 0;
        for(Map<String,Object> map : arr1){
            c = c + (int)map.get("fault_count");//根据key值获得相应的value值
        }
        int d= a - c;
        LinkedHashMap<String, Object> map1 = new LinkedHashMap<>(3);
        map1.put("fault_name","其他故障类型");
        map1.put("fault_count",d);
        if (a != 0) {
            map1.put("fault_scale",(float) d/a);
        }else map1.put("fault_scale",0.0);
        arr1.add(map1);
        Map<String, Object> map = new HashMap<>(3);
        map.put("FaultAnalysisList",arr1);

        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }

    //设备故障分析
    @PostMapping("/base/api/get/device/fault/type/analysis")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> FaultDeviceAnalysis(@RequestBody Datas datas ){
        Integer date = datas.getDate();
        List<Integer> total = mainKnowledgeDatasService.GetFaultId();
        int a = mainKnowledgeDatasService.GetFaultCount(date,datas.getDevice_code());
        List<LinkedHashMap<String, Object>> arr = new ArrayList<>();
        for(int i:total){
            LinkedHashMap<String, Object> map = new LinkedHashMap<>(3);
            map.put("fault_name",mainKnowledgeDatasService.GetFaultName(i));
            map.put("fault_count",mainKnowledgeDatasService.GetFaultCountById(i,date,datas.getDevice_code()));
            if (a !=0){
                map.put("fault_scale",(float)mainKnowledgeDatasService.GetFaultCountById(i,date,datas.getDevice_code())/a);}
            else map.put("fault_scale",0.0);
            arr.add(map);
        }
        Collections.sort(arr, new Comparator<Map<String,Object>>(){
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer o1Value = Integer.parseInt(o1.get("fault_count").toString());
                Integer o2Value = Integer.parseInt(o2.get("fault_count").toString());
                return o2Value.compareTo(o1Value);
            }
        });
        List<LinkedHashMap<String, Object>> arr1 = new ArrayList<>();
        arr1 =arr.subList(0,4);
        int c = 0;
        for(Map<String,Object> map : arr1){
            c = c + (int)map.get("fault_count");//根据key值获得相应的value值
        }
        int d= a - c;
        LinkedHashMap<String, Object> map1 = new LinkedHashMap<>(3);
        map1.put("fault_name","其他故障类型");
        map1.put("fault_count",d);
        if (a != 0) {
            map1.put("fault_scale",(float) d/a);
        }else map1.put("fault_scale",0.0);
        arr1.add(map1);
        Map<String, Object> map = new HashMap<>(3);
        map.put("FaultAnalysisList",arr1);

        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }

    //添加知识库
    @PostMapping("/base/api/get/manual/add")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> insertMain(@RequestBody AddFaultConfigDatas addFaultConfigDatas){

        MainKnowledgeDatas mainKnowledgeDatas=new MainKnowledgeDatas();
        mainKnowledgeDatas.setFault_code(addFaultConfigDatas.getFault_code());
        mainKnowledgeDatas.setFault_name(addFaultConfigDatas.getFault_name());
        mainKnowledgeDatas.setFault_type(addFaultConfigDatas.getFault_type());
        mainKnowledgeDatas.setFault_mode(addFaultConfigDatas.getFault_mode());
        mainKnowledgeDatas.setFault_suggest(addFaultConfigDatas.getFault_suggest());
        mainKnowledgeDatas.setFault_algorithm(addFaultConfigDatas.getFault_algorithm());
        mainKnowledgeDatas.setFault_feature(addFaultConfigDatas.getFault_feature());
        mainKnowledgeDatas.setFault_method(addFaultConfigDatas.getFault_method());
        mainKnowledgeDatas.setFault_reason(addFaultConfigDatas.getFault_reason());
        mainKnowledgeDatasService.insertMain(mainKnowledgeDatas);
        List<Integer> boat_id=mainKnowledgeDatasService.GetBoatId();
        for(int i:boat_id) {
            FaultStatic faultStatic = new FaultStatic();
            faultStatic.setFault_id(mainKnowledgeDatas.getId());
            faultStatic.setFault_code(mainKnowledgeDatas.getFault_code());
            faultStatic.setFault_name(mainKnowledgeDatas.getFault_name());
            faultStatic.setBoat_id(i);
            faultStatic.setFAULT_SCALE_ALL((float) 0.0);
            faultStatic.setFAULT_SCALE_SEVEN((float) 0.0);
            faultStatic.setFAULT_SCALE_MONTH((float) 0.0);
            faultStatic.setFAULT_SCALE_QUARTER((float) 0.0);
            faultStatic.setFAULT_SCALE_YEAR((float) 0.0);
            mainKnowledgeDatasService.insertFaultStatic(faultStatic);
        }
        FaultConfigDatas faultConfigDatas=new FaultConfigDatas();
        faultConfigDatas.setFault_id(mainKnowledgeDatas.getId());
        faultConfigDatas.setSign(addFaultConfigDatas.getSign());

        for(JSONObject i:addFaultConfigDatas.getParameter()) {
           faultConfigDatas.setParameter(i.getString("parameter"));
           faultConfigDatas.setMethod(i.getString("method"));
           faultConfigDatas.setThreshold(i.getString("threshold"));
           mainKnowledgeDatasService.insertFaultConfig(faultConfigDatas);
        }
        Map<String,Object> map = new HashMap<>(3);
        return new CustomizeException<>(OPERATION_THIS_CORRECT,map);
    }
}
