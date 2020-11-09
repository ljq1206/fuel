package com.heu.fuel.service.impl;


import com.heu.fuel.dao.MainKnowledgeDatasDao;
import com.heu.fuel.entity.*;
import com.heu.fuel.service.MainKnowledgeDatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainKnowledgeDatasServiceImpl implements MainKnowledgeDatasService {
    @Autowired
    private MainKnowledgeDatasDao mainKnowledgeDatasDao;

    @Override
    public List<MainKnowledgeDatas> queryAll(String find_key, String find_value, String sort_key, String sort_value) {
        return mainKnowledgeDatasDao.queryAll(find_key,find_value,sort_key,sort_value);
    }

    @Override
    public List<MainKnowledgeDatasTable> queryTable(String find_key, String find_value, String sort_key, String sort_value,Integer date,String boat_id) {
        return mainKnowledgeDatasDao.queryTable(find_key,find_value,sort_key,sort_value,date,boat_id);
    }

    @Override
    public List<FaultAnalysis> FaultAnalysis(Integer date){
        return mainKnowledgeDatasDao.FaultAnalysis(date);
    }

    @Override
    public int updateFaultRecordByMain(){
        return mainKnowledgeDatasDao.updateFaultRecordByMain();
    }

    @Override
    public List<MainKnowledgeDatas> mainOptimizationFind(){
        return mainKnowledgeDatasDao.mainOptimizationFind();
    }

    @Override
    public int updateMainKnowledgeDatas(UpdateMainKnowledgeDatas updateMainKnowledgeDatas){
        return mainKnowledgeDatasDao.updateMainKnowledgeDatas(updateMainKnowledgeDatas);
    }

    @Override
    public int updateMainOptimization(Integer fault_id){
        return mainKnowledgeDatasDao.updateMainOptimization(fault_id);
    }

    @Override
    public int GetFaultCountById( Integer date,Integer id){
        return mainKnowledgeDatasDao.GetFaultCountById(date,id);
    }//获取该故障发生次数

    @Override
    public int GetFaultCountById(Integer id, Integer date, String device_code) {
        return mainKnowledgeDatasDao.GetFaultCountById(id,date,device_code);
    }

    @Override
    public List<Integer> GetFaultId(){
        return mainKnowledgeDatasDao.GetFaultId();
    }//获取当前所有故障id

    @Override
    public int GetFaultCount(Integer date){
        return mainKnowledgeDatasDao.GetFaultCount(date);
    }//获取知识库故障数量

    @Override
    public int GetFaultCount(Integer date, String device_code) {
        return mainKnowledgeDatasDao.GetFaultCount(date,device_code);
    }

    @Override
    public String GetFaultName( Integer id){
        return mainKnowledgeDatasDao.GetFaultName(id);
    }//获取知识库故障名称

    @Override
    public int insertMain(MainKnowledgeDatas mainKnowledgeDatas){
        return mainKnowledgeDatasDao.insertMain(mainKnowledgeDatas);
    }

    @Override
    public int insertFaultStatic(FaultStatic faultStatic) {
        return mainKnowledgeDatasDao.insertFaultStatic(faultStatic);
    }

    @Override
    public  int insertFaultConfig(FaultConfigDatas faultConfigDatas){
        return mainKnowledgeDatasDao.insertFaultConfig(faultConfigDatas);
    }

    @Override
    public List<MainKnowledgeDatasTable> queryFaultTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return mainKnowledgeDatasDao.queryFaultTableSeven(find_key,find_value,sort_key,sort_value,boat_id);
    }
    @Override
    public List<MainKnowledgeDatasTable> queryFaultTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return mainKnowledgeDatasDao.queryFaultTableMonth(find_key,find_value,sort_key,sort_value,boat_id);
    }
    @Override
    public List<MainKnowledgeDatasTable> queryFaultTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return mainKnowledgeDatasDao.queryFaultTableQuarter(find_key,find_value,sort_key,sort_value,boat_id);
    }
    @Override
    public List<MainKnowledgeDatasTable> queryFaultTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return mainKnowledgeDatasDao.queryFaultTableYear(find_key,find_value,sort_key,sort_value,boat_id);
    }
    @Override
    public List<MainKnowledgeDatasTable> queryFaultTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return mainKnowledgeDatasDao.queryFaultTableAll(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List<Integer> GetBoatId() {
        return mainKnowledgeDatasDao.GetBoatId();
    }

}
