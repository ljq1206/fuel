package com.heu.fuel.controller;

import com.heu.fuel.entity.Datas;
import com.heu.fuel.entity.DatasId;
import com.heu.fuel.entity.LogActivity;
import com.heu.fuel.service.FaultRecordDatasService;
import com.heu.fuel.service.LogService;
import com.heu.fuel.service.impl.MyCustomizeErrorCode;
import com.heu.fuel.util.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;

//提供restful服务
@RestController
@Controller
@CrossOrigin
public class FaultRecordDatasController {
    @Autowired
    FaultRecordDatasService faultRecordDatasService;

    @Autowired
    private LogService logService;

    //查看故障信息记录  条件查询
    @PostMapping("/base/api/get/fault/all/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody Datas datas){
        Map<String, Object> map = new HashMap<>(3);
        map.put("faultRecordList", faultRecordDatasService.queryAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),datas.getBoat_id()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //查看未处理故障信息
    @PostMapping("/base/api/get/fault/notdeal/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> NotDealFault(@RequestBody Datas datas){
        Map<String, Object> map = new HashMap<>(3);
        map.put("faultList", faultRecordDatasService.NotDealFault(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),datas.getBoat_id(),datas.getDevice_code()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //获取当前未处理故障数量
    @GetMapping("/base/api/get/fault/notdeal/amount")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> NotDealFaultCount(){
        Map<String, Object> map = new HashMap<>(3);
        map.put("current_not_deal_fault", faultRecordDatasService.NotDealFaultCount());
        return new CustomizeException<>(MyCustomizeErrorCode.OPERATION_THIS_CORRECT, map);
    }

    //故障已处理int
    @PostMapping("/base/api/fault/deal/function1")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> isDealFault(@RequestBody DatasId datasId){
        Integer id =datasId.getId();
        faultRecordDatasService.isDealFault(id);
        Map<String, Object> map = new HashMap<>(3);

        //系统日志
        LogActivity logActivity = new LogActivity();
        logActivity.setLog_name("admin");
        logActivity.setDescription("处理故障，id号："+ id);
        logService.insertLog(logActivity);

        return new CustomizeException(MyCustomizeErrorCode.OPERATION_THIS_CORRECT, map);
    }
    //故障已处理int[]
    @PostMapping("/base/api/fault/deal/button/function")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> isDealFaultSz(@RequestParam("id") int[] id){
        faultRecordDatasService.isDealFaultSz(id);
        Map<String, Object> map = new HashMap<>(3);

        //系统日志
        StringBuffer str = new StringBuffer();
        for (int i = 0; i<id.length ; i++) {
            str = str.append(id[i]);
            str = str.append(' ');
        }
        String str1 = str.toString();
        LogActivity logActivity = new LogActivity();
        logActivity.setLog_name("admin");
        logActivity.setDescription("处理故障(批量)，id号："+ str1);
        logService.insertLog(logActivity);

        return new CustomizeException(MyCustomizeErrorCode.OPERATION_THIS_CORRECT, map);
    }

    //故障明示 以处理故障数、所占比例  未处理故障数、所占比例
    @GetMapping("/base/api/get/fault/overview")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> faultOverview(){
        ArrayList<Object> arr = new ArrayList<>(6);

        int deal_fault_count = faultRecordDatasService.DealFaultCount();
        int not_deal_fault_count = faultRecordDatasService.NotDealFaultCount();
        float fault_total = faultRecordDatasService.FaultTotal();
        float deal_fault_scale = (float)deal_fault_count / fault_total;
        float not_deal_fault_scale = (float)not_deal_fault_count / fault_total;

        Map<String, Object> mapDealFault = new HashMap<>(3);
        mapDealFault.put("type","已解决故障");
        mapDealFault.put("fault_count",deal_fault_count);
        mapDealFault.put("fault_scale", deal_fault_scale);
        arr.add(mapDealFault);

        Map<String, Object> mapNotDealFault = new HashMap<>(3);
        mapNotDealFault.put("type","待解决故障");
        mapNotDealFault.put("fault_count",not_deal_fault_count);
        mapNotDealFault.put("fault_scale", not_deal_fault_scale);
        arr.add(mapNotDealFault);

        Map<String, Object> map = new HashMap<>();
        map.put("faultOverview", arr);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //获取此设备未处理及已处理故障信息
    @PostMapping("/base/api/get/device/fault/overview")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> faultDeviceOverview(@RequestBody Datas datas){
        ArrayList<Object> arr = new ArrayList<>(6);

        int deal_fault_count = faultRecordDatasService.DealFaultCount(datas.getDevice_code());
        int not_deal_fault_count = faultRecordDatasService.NotDealFaultCount(datas.getDevice_code());
        float fault_total = faultRecordDatasService.FaultTotal(datas.getDevice_code());
        float deal_fault_scale = (float)deal_fault_count / fault_total;
        float not_deal_fault_scale = (float)not_deal_fault_count / fault_total;

        Map<String, Object> mapDealFault = new HashMap<>(3);
        mapDealFault.put("type","已解决故障");
        mapDealFault.put("fault_count",deal_fault_count);
        mapDealFault.put("fault_scale", deal_fault_scale);
        arr.add(mapDealFault);

        Map<String, Object> mapNotDealFault = new HashMap<>(3);
        mapNotDealFault.put("type","待解决故障");
        mapNotDealFault.put("fault_count",not_deal_fault_count);
        mapNotDealFault.put("fault_scale", not_deal_fault_scale);
        arr.add(mapNotDealFault);

        Map<String, Object> map = new HashMap<>();
        map.put("faultOverview", arr);
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //七天查询 案件分析
    @PostMapping("/base/api/get/case/analysis")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> CaseAnalysis(@RequestBody Datas datas){
        Integer date =datas.getDate();
        if(date==null) date=1;
        if(date == 1) {
            ArrayList<Object> arr = new ArrayList<>(6);
            LinkedHashMap<String, Object> map1 = new LinkedHashMap<>(3);
            map1.put("type", "fault");
            map1.put("abscissa", "第1天");
            map1.put("value", faultRecordDatasService.FaultSevenOne());
            arr.add(map1);
            LinkedHashMap<String, Object> map2 = new LinkedHashMap<>(3);
            map2.put("type", "fault");
            map2.put("abscissa", "第2天");
            map2.put("value", faultRecordDatasService.FaultSevenTwo());
            arr.add(map2);
            LinkedHashMap<String, Object> map3 = new LinkedHashMap<>(3);
            map3.put("type", "fault");
            map3.put("abscissa", "第3天");
            map3.put("value", faultRecordDatasService.FaultSevenThree());
            arr.add(map3);
            LinkedHashMap<String, Object> map4 = new LinkedHashMap<>(3);
            map4.put("type", "fault");
            map4.put("abscissa", "第4天");
            map4.put("value", faultRecordDatasService.FaultSevenFour());
            arr.add(map4);
            LinkedHashMap<String, Object> map5 = new LinkedHashMap<>(3);
            map5.put("type", "fault");
            map5.put("abscissa", "第5天");
            map5.put("value", faultRecordDatasService.FaultSevenFive());
            arr.add(map5);
            LinkedHashMap<String, Object> map6 = new LinkedHashMap<>(3);
            map6.put("type", "fault");
            map6.put("abscissa", "第6天");
            map6.put("value", faultRecordDatasService.FaultSevenSix());
            arr.add(map6);
            LinkedHashMap<String, Object> map7 = new LinkedHashMap<>(3);
            map7.put("type", "fault");
            map7.put("abscissa", "第7天");
            map7.put("value", faultRecordDatasService.FaultSevenSeven());
            arr.add(map7);
            LinkedHashMap<String, Object> map8 = new LinkedHashMap<>(3);
            map8.put("type", "warning");
            map8.put("abscissa", "第1天");
            map8.put("value", faultRecordDatasService.WarningSevenOne());
            arr.add(map8);
            LinkedHashMap<String, Object> map9 = new LinkedHashMap<>(3);
            map9.put("type", "warning");
            map9.put("abscissa", "第2天");
            map9.put("value", faultRecordDatasService.WarningSevenTwo());
            arr.add(map9);
            LinkedHashMap<String, Object> map10 = new LinkedHashMap<>(3);
            map10.put("type", "warning");
            map10.put("abscissa", "第3天");
            map10.put("value", faultRecordDatasService.WarningSevenThree());
            arr.add(map10);
            LinkedHashMap<String, Object> map11 = new LinkedHashMap<>(3);
            map11.put("type", "warning");
            map11.put("abscissa", "第4天");
            map11.put("value", faultRecordDatasService.WarningSevenFour());
            arr.add(map11);
            LinkedHashMap<String, Object> map12 = new LinkedHashMap<>(3);
            map12.put("type", "warning");
            map12.put("abscissa", "第5天");
            map12.put("value", faultRecordDatasService.WarningSevenFive());
            arr.add(map12);
            LinkedHashMap<String, Object> map13 = new LinkedHashMap<>(3);
            map13.put("type", "warning");
            map13.put("abscissa", "第6天");
            map13.put("value", faultRecordDatasService.WarningSevenSix());
            arr.add(map13);
            LinkedHashMap<String, Object> map14 = new LinkedHashMap<>(3);
            map14.put("type", "warning");
            map14.put("abscissa", "第7天");
            map14.put("value", faultRecordDatasService.WarningSevenSeven());
            arr.add(map14);
//            Map<String, Object> map0 = new HashMap<>(3);
            Map<String, Object> map0 = new HashMap<>(3);
            map0.put("CaseStudy", arr);
            return new CustomizeException<>(FIND_ALL_CORRECT, map0);
        }
        else if (date == 2){
            ArrayList<Object> arr2 = new ArrayList<>(6);
            LinkedHashMap<String, Object> mapMonth1 = new LinkedHashMap<>(3);
            mapMonth1.put("type", "fault");
            mapMonth1.put("abscissa", "第1周");
            mapMonth1.put("value", faultRecordDatasService.FaultMonthOne());
            arr2.add(mapMonth1);
            LinkedHashMap<String, Object> mapMonth2 = new LinkedHashMap<>(3);
            mapMonth2.put("type", "fault");
            mapMonth2.put("abscissa", "第2周");
            mapMonth2.put("value", faultRecordDatasService.FaultMonthTwo());
            arr2.add(mapMonth2);
            LinkedHashMap<String, Object> mapMonth3 = new LinkedHashMap<>(3);
            mapMonth3.put("type", "fault");
            mapMonth3.put("abscissa", "第3周");
            mapMonth3.put("value", faultRecordDatasService.FaultMonthThree());
            arr2.add(mapMonth3);
            LinkedHashMap<String, Object> mapMonth4 = new LinkedHashMap<>(3);
            mapMonth4.put("type", "fault");
            mapMonth4.put("abscissa", "第4周");
            mapMonth4.put("value", faultRecordDatasService.FaultMonthFour());
            arr2.add(mapMonth4);
            LinkedHashMap<String, Object> mapMonth5 = new LinkedHashMap<>(3);
            mapMonth5.put("type", "warning");
            mapMonth5.put("abscissa", "第1周");
            mapMonth5.put("value", faultRecordDatasService.WarnMonthOne());
            arr2.add(mapMonth5);
            LinkedHashMap<String, Object> mapMonth6 = new LinkedHashMap<>(3);
            mapMonth6.put("type", "warning");
            mapMonth6.put("abscissa", "第2周");
            mapMonth6.put("value", faultRecordDatasService.WarnMonthTwo());
            arr2.add(mapMonth6);
            LinkedHashMap<String, Object> mapMonth7 = new LinkedHashMap<>(3);
            mapMonth7.put("type", "warning");
            mapMonth7.put("abscissa", "第3周");
            mapMonth7.put("value", faultRecordDatasService.WarnMonthThree());
            arr2.add(mapMonth7);
            LinkedHashMap<String, Object> mapMonth8 = new LinkedHashMap<>(3);
            mapMonth8.put("type", "warning");
            mapMonth8.put("abscissa", "第4周");
            mapMonth8.put("value", faultRecordDatasService.WarnMonthFour());
            arr2.add(mapMonth8);
            Map<String, Object> mapMonth = new HashMap<>(3);
            mapMonth.put("CaseStudy", arr2);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapMonth);
        }
        else if (date == 3){
            ArrayList<Object> arr3 = new ArrayList<>(6);
            LinkedHashMap<String, Object> mapSeason1 = new LinkedHashMap<>(3);
            mapSeason1.put("type", "fault");
            mapSeason1.put("abscissa", "第1季度");
            mapSeason1.put("value", faultRecordDatasService.FaultSeasonOne());
            arr3.add(mapSeason1);
            LinkedHashMap<String, Object> mapSeason2 = new LinkedHashMap<>(3);
            mapSeason2.put("type", "fault");
            mapSeason2.put("abscissa", "第2季度");
            mapSeason2.put("value", faultRecordDatasService.FaultSeasonTwo());
            arr3.add(mapSeason2);
            LinkedHashMap<String, Object> mapSeason3 = new LinkedHashMap<>(3);
            mapSeason3.put("type", "fault");
            mapSeason3.put("abscissa", "第3季度");
            mapSeason3.put("value", faultRecordDatasService.FaultSeasonThree());
            arr3.add(mapSeason3);
            LinkedHashMap<String, Object> mapSeason4 = new LinkedHashMap<>(3);
            mapSeason4.put("type", "fault");
            mapSeason4.put("abscissa", "第4季度");
            mapSeason4.put("value", faultRecordDatasService.FaultSeasonFour());
            arr3.add(mapSeason4);
            LinkedHashMap<String, Object> mapSeason5 = new LinkedHashMap<>(3);
            mapSeason5.put("type", "warning");
            mapSeason5.put("abscissa", "第1季度");
            mapSeason5.put("value", faultRecordDatasService.WarnSeasonOne());
            arr3.add(mapSeason5);
            LinkedHashMap<String, Object> mapSeason6 = new LinkedHashMap<>(3);
            mapSeason6.put("type", "warning");
            mapSeason6.put("abscissa", "第2季度");
            mapSeason6.put("value", faultRecordDatasService.WarnSeasonTwo());
            arr3.add(mapSeason6);
            LinkedHashMap<String, Object> mapSeason7 = new LinkedHashMap<>(3);
            mapSeason7.put("type", "warning");
            mapSeason7.put("abscissa", "第3季度");
            mapSeason7.put("value", faultRecordDatasService.WarnSeasonThree());
            arr3.add(mapSeason7);
            LinkedHashMap<String, Object> mapSeason8 = new LinkedHashMap<>(3);
            mapSeason8.put("type", "warning");
            mapSeason8.put("abscissa", "第4季度");
            mapSeason8.put("value", faultRecordDatasService.WarnSeasonFour());
            arr3.add(mapSeason8);
            Map<String, Object> mapSeason = new HashMap<>(3);
            mapSeason.put("CaseStudy", arr3);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapSeason);
        }
        else if (date == 4){
            ArrayList<Object> arr4 = new ArrayList<>(6);
            LinkedHashMap<String, Object> mapYear1 = new LinkedHashMap<>(3);
            mapYear1.put("type", "fault");
            mapYear1.put("abscissa", "第1月");
            mapYear1.put("value", faultRecordDatasService.FaultYearOne());
            arr4.add(mapYear1);
            LinkedHashMap<String, Object> mapYear2 = new LinkedHashMap<>(3);
            mapYear2.put("type", "fault");
            mapYear2.put("abscissa", "第2月");
            mapYear2.put("value", faultRecordDatasService.FaultYearTwo());
            arr4.add(mapYear2);
            LinkedHashMap<String, Object> mapYear3 = new LinkedHashMap<>(3);
            mapYear3.put("type", "fault");
            mapYear3.put("abscissa", "第3月");
            mapYear3.put("value", faultRecordDatasService.FaultYearThree());
            arr4.add(mapYear3);
            LinkedHashMap<String, Object> mapYear4 = new LinkedHashMap<>(3);
            mapYear4.put("type", "fault");
            mapYear4.put("abscissa", "第4月");
            mapYear4.put("value", faultRecordDatasService.FaultYearFour());
            arr4.add(mapYear4);
            LinkedHashMap<String, Object> mapYear5 = new LinkedHashMap<>(3);
            mapYear5.put("type", "fault");
            mapYear5.put("abscissa", "第5月");
            mapYear5.put("value", faultRecordDatasService.FaultYearFive());
            arr4.add(mapYear5);
            LinkedHashMap<String, Object> mapYear6 = new LinkedHashMap<>(3);
            mapYear6.put("type", "fault");
            mapYear6.put("abscissa", "第6月");
            mapYear6.put("value", faultRecordDatasService.FaultYearSix());
            arr4.add(mapYear6);
            LinkedHashMap<String, Object> mapYear7 = new LinkedHashMap<>(3);
            mapYear7.put("type", "fault");
            mapYear7.put("abscissa", "第7月");
            mapYear7.put("value", faultRecordDatasService.FaultYearSeven());
            arr4.add(mapYear7);
            LinkedHashMap<String, Object> mapYear8 = new LinkedHashMap<>(3);
            mapYear8.put("type", "fault");
            mapYear8.put("abscissa", "第8月");
            mapYear8.put("value", faultRecordDatasService.FaultYearEight());
            arr4.add(mapYear8);
            LinkedHashMap<String, Object> mapYear9 = new LinkedHashMap<>(3);
            mapYear9.put("type", "fault");
            mapYear9.put("abscissa", "第9月");
            mapYear9.put("value", faultRecordDatasService.FaultYearNine());
            arr4.add(mapYear9);
            LinkedHashMap<String, Object> mapYear10 = new LinkedHashMap<>(3);
            mapYear10.put("type", "fault");
            mapYear10.put("abscissa", "第10月");
            mapYear10.put("value", faultRecordDatasService.FaultYearTen());
            arr4.add(mapYear10);
            LinkedHashMap<String, Object> mapYear11 = new LinkedHashMap<>(3);
            mapYear11.put("type", "fault");
            mapYear11.put("abscissa", "第11月");
            mapYear11.put("value", faultRecordDatasService.FaultYearEleven());
            arr4.add(mapYear11);
            LinkedHashMap<String, Object> mapYear12 = new LinkedHashMap<>(3);
            mapYear12.put("type", "fault");
            mapYear12.put("abscissa", "第12月");
            mapYear12.put("value", faultRecordDatasService.FaultYearTwelve());
            arr4.add(mapYear12);

            LinkedHashMap<String, Object> mapYear13 = new LinkedHashMap<>(3);
            mapYear13.put("type", "warning");
            mapYear13.put("abscissa", "第1月");
            mapYear13.put("value", faultRecordDatasService.WarningYearOne());
            arr4.add(mapYear13);
            LinkedHashMap<String, Object> mapYear14 = new LinkedHashMap<>(3);
            mapYear14.put("type", "warning");
            mapYear14.put("abscissa", "第2月");
            mapYear14.put("value", faultRecordDatasService.WarningYearTwo());
            arr4.add(mapYear14);
            LinkedHashMap<String, Object> mapYear15 = new LinkedHashMap<>(3);
            mapYear15.put("type", "warning");
            mapYear15.put("abscissa", "第3月");
            mapYear15.put("value", faultRecordDatasService.WarningYearThree());
            arr4.add(mapYear15);
            LinkedHashMap<String, Object> mapYear16 = new LinkedHashMap<>(3);
            mapYear16.put("type", "warning");
            mapYear16.put("abscissa", "第4月");
            mapYear16.put("value", faultRecordDatasService.WarningYearFour());
            arr4.add(mapYear16);
            LinkedHashMap<String, Object> mapYear17 = new LinkedHashMap<>(3);
            mapYear17.put("type", "warning");
            mapYear17.put("abscissa", "第5月");
            mapYear17.put("value", faultRecordDatasService.WarningYearFive());
            arr4.add(mapYear17);
            LinkedHashMap<String, Object> mapYear18 = new LinkedHashMap<>(3);
            mapYear18.put("type", "warning");
            mapYear18.put("abscissa", "第6月");
            mapYear18.put("value", faultRecordDatasService.WarningYearSix());
            arr4.add(mapYear18);
            LinkedHashMap<String, Object> mapYear19 = new LinkedHashMap<>(3);
            mapYear19.put("type", "warning");
            mapYear19.put("abscissa", "第7月");
            mapYear19.put("value", faultRecordDatasService.WarningYearSeven());
            arr4.add(mapYear19);
            LinkedHashMap<String, Object> mapYear20 = new LinkedHashMap<>(3);
            mapYear20.put("type", "warning");
            mapYear20.put("abscissa", "第8月");
            mapYear20.put("value", faultRecordDatasService.WarningYearEight());
            arr4.add(mapYear20);
            LinkedHashMap<String, Object> mapYear21 = new LinkedHashMap<>(3);
            mapYear21.put("type", "warning");
            mapYear21.put("abscissa", "第9月");
            mapYear21.put("value", faultRecordDatasService.WarningYearNine());
            arr4.add(mapYear21);
            LinkedHashMap<String, Object> mapYear22 = new LinkedHashMap<>(3);
            mapYear22.put("type", "warning");
            mapYear22.put("abscissa", "第10月");
            mapYear22.put("value", faultRecordDatasService.WarningYearTen());
            arr4.add(mapYear22);
            LinkedHashMap<String, Object> mapYear23 = new LinkedHashMap<>(3);
            mapYear23.put("type", "warning");
            mapYear23.put("abscissa", "第11月");
            mapYear23.put("value", faultRecordDatasService.WarningYearEleven());
            arr4.add(mapYear23);
            LinkedHashMap<String, Object> mapYear24 = new LinkedHashMap<>(3);
            mapYear24.put("type", "warning");
            mapYear24.put("abscissa", "第12月");
            mapYear24.put("value", faultRecordDatasService.WarningYearTwelve());
            arr4.add(mapYear24);
            Map<String, Object> mapYear = new HashMap<>(3);
            mapYear.put("CaseStudy", arr4);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapYear);
        }
        else if (date == 5){
            ArrayList<Object> arr5 = new ArrayList<>(6);
            LinkedHashMap<String, Object> mapAll1 = new LinkedHashMap<>(3);
            mapAll1.put("type", "fault");
            mapAll1.put("abscissa", "第1年");
            mapAll1.put("value", faultRecordDatasService.FaultAllOne());
            arr5.add(mapAll1);
            LinkedHashMap<String, Object> mapAll2 = new LinkedHashMap<>(3);
            mapAll2.put("type", "fault");
            mapAll2.put("abscissa", "第2年");
            mapAll2.put("value", faultRecordDatasService.FaultAllTwo());
            arr5.add(mapAll2);
            LinkedHashMap<String, Object> mapAll3 = new LinkedHashMap<>(3);
            mapAll3.put("type", "warning");
            mapAll3.put("abscissa", "第1年");
            mapAll3.put("value", faultRecordDatasService.WarnAllOne());
            arr5.add(mapAll3);
            LinkedHashMap<String, Object> mapAll4 = new LinkedHashMap<>(3);
            mapAll4.put("type", "warning");
            mapAll4.put("abscissa", "第2年");
            mapAll4.put("value", faultRecordDatasService.WarnAllTwo());
            arr5.add(mapAll4);
            Map<String, Object> mapAll = new HashMap<>(3);
            mapAll.put("CaseStudy", arr5);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapAll);
        }
        else{
            ArrayList<Object> arr = new ArrayList<>(6);
            Map<String, Object> map1 = new HashMap<>(3);
            map1.put("type", "fault");
            map1.put("abscissa", "第1天");
            map1.put("value", faultRecordDatasService.FaultSevenOne());
            arr.add(map1);
            Map<String, Object> map2 = new HashMap<>(3);
            map2.put("type", "fault");
            map2.put("abscissa", "第2天");
            map2.put("value", faultRecordDatasService.FaultSevenTwo());
            arr.add(map2);
            Map<String, Object> map3 = new HashMap<>(3);
            map3.put("type", "fault");
            map3.put("abscissa", "第3天");
            map3.put("value", faultRecordDatasService.FaultSevenThree());
            arr.add(map3);
            Map<String, Object> map4 = new HashMap<>(3);
            map4.put("type", "fault");
            map4.put("abscissa", "第4天");
            map4.put("value", faultRecordDatasService.FaultSevenFour());
            arr.add(map4);
            Map<String, Object> map5 = new HashMap<>(3);
            map5.put("type", "fault");
            map5.put("abscissa", "第5天");
            map5.put("value", faultRecordDatasService.FaultSevenFive());
            arr.add(map5);
            Map<String, Object> map6 = new HashMap<>(3);
            map6.put("type", "fault");
            map6.put("abscissa", "第6天");
            map6.put("value", faultRecordDatasService.FaultSevenSix());
            arr.add(map6);
            Map<String, Object> map7 = new HashMap<>(3);
            map7.put("type", "fault");
            map7.put("abscissa", "第7天");
            map7.put("value", faultRecordDatasService.FaultSevenSeven());
            arr.add(map7);
            Map<String, Object> map8 = new HashMap<>(3);
            map8.put("type", "warning");
            map8.put("abscissa", "第1天");
            map8.put("value", faultRecordDatasService.WarningSevenOne());
            arr.add(map8);
            Map<String, Object> map9 = new HashMap<>(3);
            map9.put("type", "warning");
            map9.put("abscissa", "第2天");
            map9.put("value", faultRecordDatasService.WarningSevenTwo());
            arr.add(map9);
            Map<String, Object> map10 = new HashMap<>(3);
            map10.put("type", "warning");
            map10.put("abscissa", "第3天");
            map10.put("value", faultRecordDatasService.WarningSevenThree());
            arr.add(map10);
            Map<String, Object> map11 = new HashMap<>(3);
            map11.put("type", "warning");
            map11.put("abscissa", "第4天");
            map11.put("value", faultRecordDatasService.WarningSevenFour());
            arr.add(map11);
            Map<String, Object> map12 = new HashMap<>(3);
            map12.put("type", "warning");
            map12.put("abscissa", "第5天");
            map12.put("value", faultRecordDatasService.WarningSevenFive());
            arr.add(map12);
            Map<String, Object> map13 = new HashMap<>(3);
            map13.put("type", "warning");
            map13.put("abscissa", "第6天");
            map13.put("value", faultRecordDatasService.WarningSevenSix());
            arr.add(map13);
            Map<String, Object> map14 = new HashMap<>(3);
            map14.put("type", "warning");
            map14.put("abscissa", "第7天");
            map14.put("value", faultRecordDatasService.WarningSevenSeven());
            arr.add(map14);
            Map<String, Object> mapWeek = new HashMap<>(3);
            mapWeek.put("CaseStudy", arr);
            return new CustomizeException<>(FIND_ALL_CORRECT, mapWeek);
        }
//        ArrayList<Object> arr5 = new ArrayList<>(6);
//        Map<String, Object> mapElse1 = new HashMap<>(3);
//        mapElse1.put("type", "fault");
//        mapElse1.put("abscissa", "第1天");
//        mapElse1.put("value", faultRecordDatasService.FaultSevenOne());
//        arr5.add(mapElse1);
//        Map<String, Object> mapElse2 = new HashMap<>(3);
//        mapElse2.put("type", "fault");
//        mapElse2.put("abscissa", "第2天");
//        mapElse2.put("value", faultRecordDatasService.FaultSevenTwo());
//        arr5.add(mapElse2);
//        Map<String, Object> mapElse3 = new HashMap<>(3);
//        map3.put("type", "fault");
//        map3.put("abscissa", "第3天");
//        map3.put("value", faultRecordDatasService.FaultSevenThree());
//        arr.add(map3);
//        Map<String, Object> map4 = new HashMap<>(3);
//        map4.put("type", "fault");
//        map4.put("abscissa", "第4天");
//        map4.put("value", faultRecordDatasService.FaultSevenFour());
//        arr.add(map4);
//        Map<String, Object> map5 = new HashMap<>(3);
//        map5.put("type", "fault");
//        map5.put("abscissa", "第5天");
//        map5.put("value", faultRecordDatasService.FaultSevenFive());
//        arr.add(map5);
//        Map<String, Object> map6 = new HashMap<>(3);
//        map6.put("type", "fault");
//        map6.put("abscissa", "第6天");
//        map6.put("value", faultRecordDatasService.FaultSevenSix());
//        arr.add(map6);
//        Map<String, Object> map7 = new HashMap<>(3);
//        map7.put("type", "fault");
//        map7.put("abscissa", "第7天");
//        map7.put("value", faultRecordDatasService.FaultSevenSeven());
//        arr.add(map7);
//        Map<String, Object> map8 = new HashMap<>(3);
//        map8.put("type", "warning");
//        map8.put("abscissa", "第1天");
//        map8.put("value", faultRecordDatasService.WarningSevenOne());
//        arr.add(map8);
//        Map<String, Object> map9 = new HashMap<>(3);
//        map9.put("type", "warning");
//        map9.put("abscissa", "第2天");
//        map9.put("value", faultRecordDatasService.WarningSevenTwo());
//        arr.add(map9);
//        Map<String, Object> map10 = new HashMap<>(3);
//        map10.put("type", "warning");
//        map10.put("abscissa", "第3天");
//        map10.put("value", faultRecordDatasService.WarningSevenThree());
//        arr.add(map10);
//        Map<String, Object> map11 = new HashMap<>(3);
//        map11.put("type", "warning");
//        map11.put("abscissa", "第4天");
//        map11.put("value", faultRecordDatasService.WarningSevenFour());
//        arr.add(map11);
//        Map<String, Object> map12 = new HashMap<>(3);
//        map12.put("type", "warning");
//        map12.put("abscissa", "第5天");
//        map12.put("value", faultRecordDatasService.WarningSevenFive());
//        arr.add(map12);
//        Map<String, Object> map13 = new HashMap<>(3);
//        map13.put("type", "warning");
//        map13.put("abscissa", "第6天");
//        map13.put("value", faultRecordDatasService.WarningSevenSix());
//        arr.add(map13);
//        Map<String, Object> map14 = new HashMap<>(3);
//        map14.put("type", "warning");
//        map14.put("abscissa", "第7天");
//        map14.put("value", faultRecordDatasService.WarningSevenSeven());
//        arr.add(map14);

//        Map<String, Object> mapWeek = new HashMap<>(3);
//
//        return new CustomizeException<>(FIND_ALL_CORRECT, mapWeek);
    }

}
