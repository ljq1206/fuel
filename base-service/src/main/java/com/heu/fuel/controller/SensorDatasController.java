package com.heu.fuel.controller;

import com.alibaba.fastjson.JSON;
import com.heu.fuel.entity.Datas;
import com.heu.fuel.service.SensorDatasService;
import com.heu.fuel.util.CustomizeException;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;

//提供restful服务
@RestController
@Controller
@CrossOrigin
public class SensorDatasController {
    @Autowired
    SensorDatasService sensorDatasService;


    //查看历史数据信息
    @PostMapping("/base/api/get/raw/data")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody(required = false) Datas datas){
        List<String> arr =new ArrayList<>();
        String str =datas.getFault_data_id();
        if(str!=null) {
             arr = Arrays.asList(datas.getFault_data_id().split(","));
        }
        Map<String, Object> map = new HashMap<>(3);
        map.put("rawDataList", sensorDatasService.queryAll(datas.getDevice_code(),arr,datas.getStart_time(),datas.getEnd_time(),datas.getSort_key(), datas.getSort_value()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }


    //数据总览
    @GetMapping("/base/api/get/overview")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> totalData(){

        ArrayList<Map<String,Object>> arr = new ArrayList<>(6);

        Map<String, Object> mapBoat = new HashMap<>(3);
        mapBoat.put("boat_total",sensorDatasService.Boat_total());
        arr.add(mapBoat);

        Map<String, Object> mapDevice = new HashMap<>(3);
        mapDevice.put("device_total", sensorDatasService.Device_total());
        arr.add(mapDevice);

        Map<String, Object> mapFault_type = new HashMap<>(3);
        mapFault_type.put("fault_type_total", sensorDatasService.Fault_type_total());
        arr.add(mapFault_type);

        Map<String, Object> mapFault = new HashMap<>(3);
        mapFault.put("fault__total", sensorDatasService.Fault__total());
        arr.add(mapFault);

        Map<String, Object> mapWarn = new HashMap<>(3);
        mapWarn.put("warning_total", sensorDatasService.Warning_total());
        arr.add(mapWarn);

        Map<String, Object> map = new HashMap<>();
        map.put("dataOverview", arr);

        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //趋势图
    @PostMapping("/base/api/get/trend")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> trend(@RequestBody Datas datas){
        Integer date = datas.getDate();
        if(date == null) date=1;
        if(date == 1){
            ArrayList<Object> arr = new ArrayList<>(7);
            LinkedHashMap<String, Object> map1 = new LinkedHashMap<>(5);
            map1.put("abscissa", "第1天");
            map1.put("fault", sensorDatasService.FaultSevenOne());
            map1.put("warning",sensorDatasService.WarningSevenOne());
            map1.put("device",sensorDatasService.DeviceSevenOne());
            map1.put("boat",sensorDatasService.BoatSevenOne());
            arr.add(map1);
            LinkedHashMap<String, Object> map2 = new LinkedHashMap<>(5);
            map2.put("abscissa", "第2天");
            map2.put("fault", sensorDatasService.FaultSevenTwo());
            map2.put("warning",sensorDatasService.WarningSevenTwo());
            map2.put("device",sensorDatasService.DeviceSevenTwo());
            map2.put("boat",sensorDatasService.BoatSevenTwo());
            arr.add(map2);
            LinkedHashMap<String, Object> map3 = new LinkedHashMap<>(5);
            map3.put("abscissa", "第3天");
            map3.put("fault", sensorDatasService.FaultSevenThree());
            map3.put("warning",sensorDatasService.WarningSevenThree());
            map3.put("device",sensorDatasService.DeviceSevenThree());
            map3.put("boat",sensorDatasService.BoatSevenThree());
            arr.add(map3);
            LinkedHashMap<String, Object> map4 = new LinkedHashMap<>(5);
            map4.put("abscissa", "第4天");
            map4.put("fault", sensorDatasService.FaultSevenFour());
            map4.put("warning",sensorDatasService.WarningSevenFour());
            map4.put("device",sensorDatasService.DeviceSevenFour());
            map4.put("boat",sensorDatasService.BoatSevenFour());
            arr.add(map4);
            LinkedHashMap<String, Object> map5 = new LinkedHashMap<>(5);
            map5.put("abscissa", "第5天");
            map5.put("fault", sensorDatasService.FaultSevenFive());
            map5.put("warning",sensorDatasService.WarningSevenFive());
            map5.put("device",sensorDatasService.DeviceSevenFive());
            map5.put("boat",sensorDatasService.BoatSevenFive());
            arr.add(map5);
            LinkedHashMap<String, Object> map6 = new LinkedHashMap<>(5);
            map6.put("abscissa", "第6天");
            map6.put("fault", sensorDatasService.FaultSevenSix());
            map6.put("warning",sensorDatasService.WarningSevenSix());
            map6.put("device",sensorDatasService.DeviceSevenSix());
            map6.put("boat",sensorDatasService.BoatSevenSix());
            arr.add(map6);
            LinkedHashMap<String, Object> map7 = new LinkedHashMap<>(5);
            map7.put("abscissa", "第7天");
            map7.put("fault", sensorDatasService.FaultSevenSeven());
            map7.put("warning",sensorDatasService.WarningSevenSeven());
            map7.put("device",sensorDatasService.DeviceSevenSeven());
            map7.put("boat",sensorDatasService.BoatSevenSeven());
            arr.add(map7);
            Map<String, Object> map0 = new HashMap<>(3);
            map0.put("trend", arr);
            return new CustomizeException<>(FIND_ALL_CORRECT, map0);
        }
        else if(date == 2){
            ArrayList<Object> arr2 = new ArrayList<>(7);
            LinkedHashMap<String, Object> mapMonth1 = new LinkedHashMap<>(5);
            mapMonth1.put("abscissa", "第1周");
            mapMonth1.put("fault", sensorDatasService.FaultMonthOne());
            mapMonth1.put("warning",sensorDatasService.WarningMonthOne());
            mapMonth1.put("device",sensorDatasService.DeviceMonthOne());
            mapMonth1.put("boat",sensorDatasService.BoatMonthOne());
            arr2.add(mapMonth1);
            LinkedHashMap<String, Object> mapMonth2 = new LinkedHashMap<>(5);
            mapMonth2.put("abscissa", "第2周");
            mapMonth2.put("fault", sensorDatasService.FaultMonthTwo());
            mapMonth2.put("warning",sensorDatasService.WarningMonthTwo());
            mapMonth2.put("device",sensorDatasService.DeviceMonthTwo());
            mapMonth2.put("boat",sensorDatasService.BoatMonthTwo());
            arr2.add(mapMonth2);
            LinkedHashMap<String, Object> mapMonth3 = new LinkedHashMap<>(5);
            mapMonth3.put("abscissa", "第3周");
            mapMonth3.put("fault", sensorDatasService.FaultMonthThree());
            mapMonth3.put("warning",sensorDatasService.WarningMonthThree());
            mapMonth3.put("device",sensorDatasService.DeviceMonthThree());
            mapMonth3.put("boat",sensorDatasService.BoatMonthThree());
            arr2.add(mapMonth3);
            LinkedHashMap<String, Object> mapMonth4 = new LinkedHashMap<>(5);
            mapMonth4.put("abscissa", "第4周");
            mapMonth4.put("fault", sensorDatasService.FaultMonthFour());
            mapMonth4.put("warning",sensorDatasService.WarningMonthFour());
            mapMonth4.put("device",sensorDatasService.DeviceMonthFour());
            mapMonth4.put("boat",sensorDatasService.BoatMonthFour());
            arr2.add(mapMonth4);
            Map<String, Object> mapMonth = new HashMap<>(3);
            mapMonth.put("trend", arr2);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapMonth);
        }
        else if(date == 3){
            ArrayList<Object> arr3 = new ArrayList<>(7);
            LinkedHashMap<String, Object> mapSeason1 = new LinkedHashMap<>(5);
            mapSeason1.put("abscissa", "第1季度");
            mapSeason1.put("fault", sensorDatasService.FaultSeasonOne());
            mapSeason1.put("warning",sensorDatasService.WarningSeasonOne());
            mapSeason1.put("device",sensorDatasService.DeviceSeasonOne());
            mapSeason1.put("boat",sensorDatasService.BoatSeasonOne());
            arr3.add(mapSeason1);
            LinkedHashMap<String, Object> mapSeason2 = new LinkedHashMap<>(5);
            mapSeason2.put("abscissa", "第2季度");
            mapSeason2.put("fault", sensorDatasService.FaultSeasonTwo());
            mapSeason2.put("warning",sensorDatasService.WarningSeasonTwo());
            mapSeason2.put("device",sensorDatasService.DeviceSeasonTwo());
            mapSeason2.put("boat",sensorDatasService.BoatSeasonTwo());
            arr3.add(mapSeason2);
            LinkedHashMap<String, Object> mapSeason3 = new LinkedHashMap<>(5);
            mapSeason3.put("abscissa", "第3季度");
            mapSeason3.put("fault", sensorDatasService.FaultSeasonThree());
            mapSeason3.put("warning",sensorDatasService.WarningSeasonThree());
            mapSeason3.put("device",sensorDatasService.DeviceSeasonThree());
            mapSeason3.put("boat",sensorDatasService.BoatSeasonThree());
            arr3.add(mapSeason3);
            LinkedHashMap<String, Object> mapSeason4 = new LinkedHashMap<>(5);
            mapSeason4.put("abscissa", "第4季度");
            mapSeason4.put("fault", sensorDatasService.FaultSeasonFour());
            mapSeason4.put("warning",sensorDatasService.WarningSeasonFour());
            mapSeason4.put("device",sensorDatasService.DeviceSeasonFour());
            mapSeason4.put("boat",sensorDatasService.BoatSeasonFour());
            arr3.add(mapSeason4);
            Map<String, Object> mapSeason = new HashMap<>(3);
            mapSeason.put("trend", arr3);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapSeason);
        }
        else if(date == 4){
            ArrayList<Object> arr4 = new ArrayList<>(7);
            LinkedHashMap<String, Object> mapYear1 = new LinkedHashMap<>(5);
            mapYear1.put("abscissa", "第1月");
            mapYear1.put("fault", sensorDatasService.FaultYearOne());
            mapYear1.put("warning",sensorDatasService.WarningYearOne());
            mapYear1.put("device",sensorDatasService.DeviceYearOne());
            mapYear1.put("boat",sensorDatasService.BoatYearOne());
            arr4.add(mapYear1);
            LinkedHashMap<String, Object> mapYear2 = new LinkedHashMap<>(5);
            mapYear2.put("abscissa", "第2月");
            mapYear2.put("fault", sensorDatasService.FaultYearTwo());
            mapYear2.put("warning",sensorDatasService.WarningYearTwo());
            mapYear2.put("device",sensorDatasService.DeviceYearTwo());
            mapYear2.put("boat",sensorDatasService.BoatYearTwo());
            arr4.add(mapYear2);
            LinkedHashMap<String, Object> mapYear3 = new LinkedHashMap<>(5);
            mapYear3.put("abscissa", "第3月");
            mapYear3.put("fault", sensorDatasService.FaultYearThree());
            mapYear3.put("warning",sensorDatasService.WarningYearThree());
            mapYear3.put("device",sensorDatasService.DeviceYearThree());
            mapYear3.put("boat",sensorDatasService.BoatYearThree());
            arr4.add(mapYear3);
            LinkedHashMap<String, Object> mapYear4 = new LinkedHashMap<>(5);
            mapYear4.put("abscissa", "第4月");
            mapYear4.put("fault", sensorDatasService.FaultYearFour());
            mapYear4.put("warning",sensorDatasService.WarningYearFour());
            mapYear4.put("device",sensorDatasService.DeviceYearFour());
            mapYear4.put("boat",sensorDatasService.BoatYearFour());
            arr4.add(mapYear4);
            LinkedHashMap<String, Object> mapYear5 = new LinkedHashMap<>(5);
            mapYear5.put("abscissa", "第5月");
            mapYear5.put("fault", sensorDatasService.FaultYearFive());
            mapYear5.put("warning",sensorDatasService.WarningYearFive());
            mapYear5.put("device",sensorDatasService.DeviceYearFive());
            mapYear5.put("boat",sensorDatasService.BoatYearFive());
            arr4.add(mapYear5);
            LinkedHashMap<String, Object> mapYear6 = new LinkedHashMap<>(5);
            mapYear6.put("abscissa", "第6月");
            mapYear6.put("fault", sensorDatasService.FaultYearSix());
            mapYear6.put("warning",sensorDatasService.WarningYearSix());
            mapYear6.put("device",sensorDatasService.DeviceYearSix());
            mapYear6.put("boat",sensorDatasService.BoatYearSix());
            arr4.add(mapYear6);
            LinkedHashMap<String, Object> mapYear7 = new LinkedHashMap<>(5);
            mapYear7.put("abscissa", "第7月");
            mapYear7.put("fault", sensorDatasService.FaultYearSeven());
            mapYear7.put("warning",sensorDatasService.WarningYearSeven());
            mapYear7.put("device",sensorDatasService.DeviceYearSeven());
            mapYear7.put("boat",sensorDatasService.BoatYearSeven());
            arr4.add(mapYear7);
            LinkedHashMap<String, Object> mapYear8 = new LinkedHashMap<>(5);
            mapYear8.put("abscissa", "第8月");
            mapYear8.put("fault", sensorDatasService.FaultYearEight());
            mapYear8.put("warning",sensorDatasService.WarningYearEight());
            mapYear8.put("device",sensorDatasService.DeviceYearEight());
            mapYear8.put("boat",sensorDatasService.BoatYearEight());
            arr4.add(mapYear8);
            LinkedHashMap<String, Object> mapYear9 = new LinkedHashMap<>(5);
            mapYear9.put("abscissa", "第9月");
            mapYear9.put("fault", sensorDatasService.FaultYearNine());
            mapYear9.put("warning",sensorDatasService.WarningYearNine());
            mapYear9.put("device",sensorDatasService.DeviceYearNine());
            mapYear9.put("boat",sensorDatasService.BoatYearNine());
            arr4.add(mapYear9);
            LinkedHashMap<String, Object> mapYear10 = new LinkedHashMap<>(5);
            mapYear10.put("abscissa", "第10月");
            mapYear10.put("fault", sensorDatasService.FaultYearTen());
            mapYear10.put("warning",sensorDatasService.WarningYearTen());
            mapYear10.put("device",sensorDatasService.DeviceYearTen());
            mapYear10.put("boat",sensorDatasService.BoatYearTen());
            arr4.add(mapYear10);
            LinkedHashMap<String, Object> mapYear11 = new LinkedHashMap<>(5);
            mapYear11.put("abscissa", "第11月");
            mapYear11.put("fault", sensorDatasService.FaultYearEleven());
            mapYear11.put("warning",sensorDatasService.WarningYearEleven());
            mapYear11.put("device",sensorDatasService.DeviceYearEleven());
            mapYear11.put("boat",sensorDatasService.BoatYearEleven());
            arr4.add(mapYear11);
            LinkedHashMap<String, Object> mapYear12 = new LinkedHashMap<>(5);
            mapYear12.put("abscissa", "第12月");
            mapYear12.put("fault", sensorDatasService.FaultYearTwelve());
            mapYear12.put("warning",sensorDatasService.WarningYearTwelve());
            mapYear12.put("device",sensorDatasService.DeviceYearTwelve());
            mapYear12.put("boat",sensorDatasService.BoatYearTwelve());
            arr4.add(mapYear12);
            Map<String, Object> mapYear = new HashMap<>(3);
            mapYear.put("trend", arr4);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapYear);
        }
        else if(date == 5){
            ArrayList<Object> arr5 = new ArrayList<>(7);
            LinkedHashMap<String, Object> mapAll1 = new LinkedHashMap<>(5);
            mapAll1.put("abscissa", "第1年");
            mapAll1.put("fault", sensorDatasService.FaultAllOne());
            mapAll1.put("warning",sensorDatasService.WarningAllOne());
            mapAll1.put("device",sensorDatasService.DeviceAllOne());
            mapAll1.put("boat",sensorDatasService.BoatAllOne());
            arr5.add(mapAll1);
            LinkedHashMap<String, Object> mapAll2 = new LinkedHashMap<>(5);
            mapAll2.put("abscissa", "第2年");
            mapAll2.put("fault", sensorDatasService.FaultAllTwo());
            mapAll2.put("warning",sensorDatasService.WarningAllTwo());
            mapAll2.put("device",sensorDatasService.DeviceAllTwo());
            mapAll2.put("boat",sensorDatasService.BoatAllTwo());
            arr5.add(mapAll2);
            Map<String, Object> mapAll = new HashMap<>(3);
            mapAll.put("trend", arr5);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapAll);

        }
        Map<String, Object> mapElse = new HashMap<>(3);
        return new CustomizeException<>(FIND_ALL_CORRECT, mapElse);
    }

}
