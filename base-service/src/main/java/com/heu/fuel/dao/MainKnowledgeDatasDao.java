package com.heu.fuel.dao;


import com.heu.fuel.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MainKnowledgeDatasDao {
    public List<MainKnowledgeDatas> queryAll(String find_key, String find_value, String sort_key, String sort_value);

    public List<MainKnowledgeDatasTable> queryTable(String find_key, String find_value, String sort_key, String sort_value, Integer date,String boat_id);

    public List<FaultAnalysis> FaultAnalysis(@Param("date") Integer date);//故障分析

    public List<MainKnowledgeDatas> mainOptimizationFind();//根据fault_id 从知识库获取信息

    public int updateFaultRecordByMain();// 根据知识库更新故障记录

    public int updateMainKnowledgeDatas(UpdateMainKnowledgeDatas updateMainKnowledgeDatas);//确认优化

    public int updateMainOptimization(@Param("fault_id") Integer fault_id); //取消优化

    public int GetFaultCountById(@Param("id") Integer id,@Param("date") Integer date);//获取该故障发生次数

    public int GetFaultCountById(@Param("id") Integer id,@Param("date") Integer date,@Param("device_code") String device_code);//获取该设备故障发生次数

    public List<Integer> GetFaultId();//获取当前所有故障id

    public int GetFaultCount(@Param("date") Integer date);//获取知识库故障数量

    public int GetFaultCount(@Param("date") Integer date,@Param("device_code") String device_code);

    public String GetFaultName(@Param("id") Integer id);//获取知识库故障名称

    public int insertMain(MainKnowledgeDatas mainKnowledgeDatas);

    public int insertFaultStatic(FaultStatic faultStatic);

    public  int insertFaultConfig(FaultConfigDatas faultConfigDatas);

    public List<MainKnowledgeDatasTable> queryFaultTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id);
    public List<MainKnowledgeDatasTable> queryFaultTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id);
    public List<MainKnowledgeDatasTable> queryFaultTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id);
    public List<MainKnowledgeDatasTable> queryFaultTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id);
    public List<MainKnowledgeDatasTable> queryFaultTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List<Integer> GetBoatId();//获取船只id
}
