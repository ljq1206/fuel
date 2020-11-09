package com.heu.fuel.service;

import com.heu.fuel.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//3.定义接口

public interface LogService {

    public List<Log> queryAll(String find_key, String find_value, String sort_key, String sort_value);

    public int insertLog(LogActivity logActivity);  //将数据操作插入数据库日志表中

}
