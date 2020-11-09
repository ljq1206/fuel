package com.heu.fuel.controller;

import com.heu.fuel.entity.Datas;
import com.heu.fuel.entity.DatasId;
import com.heu.fuel.entity.LogActivity;
import com.heu.fuel.service.LogService;
import com.heu.fuel.service.WarnRecordDatasService;
import com.heu.fuel.service.impl.MyCustomizeErrorCode;
import com.heu.fuel.util.CustomizeException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;

//提供restful服务
@RestController
@Controller
@CrossOrigin
public class WarnRecordDatasController {
    @Autowired
    WarnRecordDatasService warnRecordDatasService;

    @Autowired
    private LogService logService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    //查看预警信息记录  条件查询
    @PostMapping("/base/api/get/warning/all/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody Datas datas){
        Map<String, Object> map = new HashMap<>(3);
        map.put("warningRecordList", warnRecordDatasService.queryAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),datas.getBoat_id()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //查看未处理预警信息
    @PostMapping("/base/api/get/warning/notdeal/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> NotDealWarning(@RequestBody Datas datas){

        Map<String, Object> map = new HashMap<>(3);
        map.put("warningList", warnRecordDatasService.NotDealWarning(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value(),datas.getBoat_id(),datas.getDevice_code()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }

    //获取当前未处理预警数量
    @GetMapping("/base/api/get/warning/notdeal/amount")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> NotDealWarningCount(){
        Map<String, Object> map = new HashMap<>(3);
        map.put("current_not_deal_warning",warnRecordDatasService.NotDealWarningCount());
        return new CustomizeException(MyCustomizeErrorCode.OPERATION_THIS_CORRECT, map);
    }

    //处理预警int
    @PostMapping("/base/api/warning/deal/function")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> isDealFault(@RequestBody DatasId datasId ){
        Integer id =datasId.getId();
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        warnRecordDatasService.isDealWarning(id,datasId.getUser_id(),datasId.getUsername(),sdf.format(date));
        rabbitTemplate.convertAndSend("warning_data", null, warnRecordDatasService.NotDealWarningCount());
        Map<String, Object> map = new HashMap<>(3);

        return new CustomizeException(MyCustomizeErrorCode.OPERATION_THIS_CORRECT, map);
    }

    //处理预警int[]
    @PostMapping("/base/api/warning/deal/button/function")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> isDealFaultSz(@RequestParam("id") int[] id){
        warnRecordDatasService.isDealWarningSz(id);
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
        logActivity.setDescription("处理预警(批量)，id号："+ str1);
        logService.insertLog(logActivity);

        return new CustomizeException(MyCustomizeErrorCode.OPERATION_THIS_CORRECT, map);
    }
}
