package com.heu.fuel.dao;

import com.heu.fuel.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//2.实体接口

@Mapper
@Repository
public interface LogDao {
    public List<Log> queryAll(String find_key, String find_value, String sort_key, String sort_value);

    public int insertLog(LogActivity logActivity);  //将数据操作插入数据库日志表中
}
