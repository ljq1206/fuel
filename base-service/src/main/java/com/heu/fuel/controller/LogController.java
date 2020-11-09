package com.heu.fuel.controller;

import com.heu.fuel.entity.Datas;
import com.heu.fuel.service.LogService;
import com.heu.fuel.util.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.heu.fuel.service.impl.MyCustomizeErrorCode.FIND_ALL_CORRECT;

//6. 写完resource文件夹中的mapper.xml 然后最后写控制
//提供restful服务
@RestController
@Controller
@CrossOrigin
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/base/api/get/log/information")
    @CrossOrigin
    @ResponseBody
    public CustomizeException<Map> queryAll(@RequestBody Datas datas){

        Map<String, Object> map = new HashMap<>(3);
        map.put("LogList", logService.queryAll(datas.getFind_key(), datas.getFind_value(), datas.getSort_key(), datas.getSort_value()));
        return new CustomizeException<>(FIND_ALL_CORRECT, map);
    }
}
