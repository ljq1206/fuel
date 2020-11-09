package com.heu.fuel.controller;

import com.heu.fuel.entity.Datas;
import com.heu.fuel.entity.FaultEvaluation;
import com.heu.fuel.service.FaultEvaluationService;
import com.heu.fuel.util.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;

//6. 写完resource文件夹中的mapper.xml 然后最后写控制
//提供restful服务
@RestController
@Controller
@CrossOrigin
public class FaultEvaluationController {
    @Autowired
    private FaultEvaluationService faultEvaluationService;


    //【评价】按钮功能
    @PostMapping("/base/api/fault/deal/estimate")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> insertEvaluation(@RequestBody FaultEvaluation faultEvaluation){

        faultEvaluationService.insertEvaluation(faultEvaluation);
        faultEvaluationService.updateFaultRecord(faultEvaluation.getFault_record_id());
        faultEvaluationService.updateFaultEvaluationByFaultRecord();
        int id =faultEvaluation.getId();
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }

    //查看故障评价信息
    @PostMapping("/base/api/get/fault/estimate/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> findEvaluationRecord(@RequestBody Datas datas){
        faultEvaluationService.updateFaultEvaluationByFaultRecord();
        Map<String, Object> map = new HashMap<>();
        map.put("faultEstimateList",faultEvaluationService.findEvaluation(datas.getFind_key(),datas.getFind_value(),datas.getSort_key(),datas.getSort_value()));
        return new CustomizeException<>(FIND_ALL_CORRECT,map);
    }
}
