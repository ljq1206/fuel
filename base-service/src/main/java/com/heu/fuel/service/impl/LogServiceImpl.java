package com.heu.fuel.service.impl;

import com.heu.fuel.dao.LogDao;
import com.heu.fuel.entity.*;
import com.heu.fuel.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//4.实现接口

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> queryAll(String find_key, String find_value, String sort_key, String sort_value){
        return logDao.queryAll(find_key,find_value,sort_key,sort_value);
    }

    @Override
    public int insertLog(LogActivity logActivity){  //将数据操作插入数据库日志表中
        return logDao.insertLog(logActivity);
    }


}
