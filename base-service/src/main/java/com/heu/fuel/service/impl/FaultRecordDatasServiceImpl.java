package com.heu.fuel.service.impl;

import com.heu.fuel.dao.FaultRecordDatasDao;
import com.heu.fuel.entity.FaultRecordDatas;
import com.heu.fuel.entity.MainKnowledgeDatas;
import com.heu.fuel.entity.NotDealFault;
import com.heu.fuel.service.FaultRecordDatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultRecordDatasServiceImpl implements FaultRecordDatasService {
    @Autowired
    FaultRecordDatasDao faultRecordDatasDao;

    @Override
    public List<FaultRecordDatas> queryAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id) {
        return faultRecordDatasDao.queryAll(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List<NotDealFault> NotDealFault(String find_key, String find_value, String sort_key, String sort_value,String boat_id,String device_code) {
        return faultRecordDatasDao.NotDealFault(find_key,find_value,sort_key,sort_value,boat_id,device_code);
    }

    @Override
    public int isDealFault(Integer id){
        return faultRecordDatasDao.isDealFault(id);
    }

    @Override
    public int isDealFaultSz(int[] id){
        return faultRecordDatasDao.isDealFaultSz(id);
    }

    @Override
    public int NotDealFaultCount(){
        return faultRecordDatasDao.NotDealFaultCount();
    }
    @Override
    public int DealFaultCount(){
        return faultRecordDatasDao.DealFaultCount();
    }
    @Override
    public int FaultTotal(){
        return faultRecordDatasDao.FaultTotal();
    }

    @Override
    public int NotDealFaultCount(String device_code) {
        return faultRecordDatasDao.NotDealFaultCount(device_code);
    }

    @Override
    public int DealFaultCount(String device_code) {
        return faultRecordDatasDao.DealFaultCount(device_code);
    }

    @Override
    public int FaultTotal(String device_code) {
        return faultRecordDatasDao.FaultTotal(device_code);
    }

    //故障7天查询
    @Override
    public int FaultSevenOne(){
        return faultRecordDatasDao.FaultSevenOne();
    }//七天查询第一天
    @Override
    public int FaultSevenTwo(){
        return faultRecordDatasDao.FaultSevenTwo();
    }//七天查询第er天
    @Override
    public int FaultSevenThree(){
        return faultRecordDatasDao.FaultSevenThree();
    }//七天查询第san天
    @Override
    public int FaultSevenFour(){
        return faultRecordDatasDao.FaultSevenFour();
    }//七天查询第si天
    @Override
    public int FaultSevenFive(){
        return faultRecordDatasDao.FaultSevenFive();
    }//七天查询第wu天
    @Override
    public int FaultSevenSix(){
        return faultRecordDatasDao.FaultSevenSix();
    }//七天查询第liu天
    @Override
    public int FaultSevenSeven(){
        return faultRecordDatasDao.FaultSevenSeven();
    }//七天查询第qi天

    //预警7天查询
    @Override
    public int WarningSevenOne(){
        return faultRecordDatasDao.WarningSevenOne();
    }//七天查询第一天
    @Override
    public int WarningSevenTwo(){
        return faultRecordDatasDao.WarningSevenTwo();
    }//七天查询第er天
    @Override
    public int WarningSevenThree(){
        return faultRecordDatasDao.WarningSevenThree();
    }//七天查询第san天
    @Override
    public int WarningSevenFour(){
        return faultRecordDatasDao.WarningSevenFour();
    }//七天查询第si天
    @Override
    public int WarningSevenFive(){
        return faultRecordDatasDao.WarningSevenFive();
    }//七天查询第wu天
    @Override
    public int WarningSevenSix(){
        return faultRecordDatasDao.WarningSevenSix();
    }//七天查询第liu天
    @Override
    public int WarningSevenSeven(){
        return faultRecordDatasDao.WarningSevenSeven();
    }//七天查询第qi天


    //故障月查询
    @Override
    public int FaultMonthOne(){
        return faultRecordDatasDao.FaultMonthOne();
    }//月查询第一周
    @Override
    public int FaultMonthTwo(){
        return faultRecordDatasDao.FaultMonthTwo();
    }//月查询第2周
    @Override
    public int FaultMonthThree(){
        return faultRecordDatasDao.FaultMonthThree();
    }//月查询第3周
    @Override
    public int FaultMonthFour(){
        return faultRecordDatasDao.FaultMonthFour();
    }//月查询第4周
    //预警月查询
    @Override
    public int WarnMonthOne(){
        return faultRecordDatasDao.WarnMonthOne();
    }//月查询第一周
    @Override
    public int WarnMonthTwo(){
        return faultRecordDatasDao.WarnMonthTwo();
    }//月查询第2周
    @Override
    public int WarnMonthThree(){
        return faultRecordDatasDao.WarnMonthThree();
    }//月查询第3周
    @Override
    public int WarnMonthFour(){
        return faultRecordDatasDao.WarnMonthFour();
    }//月查询第4周


    //故障季度查询
    @Override
    public int FaultSeasonOne(){
        return faultRecordDatasDao.FaultSeasonOne();
    }//季度查询第一
    @Override
    public int FaultSeasonTwo(){
        return faultRecordDatasDao.FaultSeasonTwo();
    }//季度查询第2
    @Override
    public int FaultSeasonThree(){
        return faultRecordDatasDao.FaultSeasonThree();
    }//季度查询第3
    @Override
    public int FaultSeasonFour(){
        return faultRecordDatasDao.FaultSeasonFour();
    }//季度查询第4
    //预警季度查询
    @Override
    public int WarnSeasonOne(){
        return faultRecordDatasDao.WarnSeasonOne();
    }//季度查询第一
    @Override
    public int WarnSeasonTwo(){
        return faultRecordDatasDao.WarnSeasonTwo();
    }//季度查询第2
    @Override
    public int WarnSeasonThree(){
        return faultRecordDatasDao.WarnSeasonThree();
    }//季度查询第3
    @Override
    public int WarnSeasonFour(){
        return faultRecordDatasDao.WarnSeasonFour();
    }//季度查询第4

    //故障年查询
    @Override
    public int FaultYearOne(){
        return faultRecordDatasDao.FaultYearOne();
    }//七天查询第一天
    @Override
    public int FaultYearTwo(){
        return faultRecordDatasDao.FaultYearTwo();
    }//七天查询第er天
    @Override
    public int FaultYearThree(){
        return faultRecordDatasDao.FaultYearThree();
    }//七天查询第san天
    @Override
    public int FaultYearFour(){
        return faultRecordDatasDao.FaultYearFour();
    }//七天查询第si天
    @Override
    public int FaultYearFive(){
        return faultRecordDatasDao.FaultYearFive();
    }//七天查询第wu天
    @Override
    public int FaultYearSix(){
        return faultRecordDatasDao.FaultYearSix();
    }//七天查询第liu天
    @Override
    public int FaultYearSeven(){
        return faultRecordDatasDao.FaultYearSeven();
    }//七天查询第qi天
    @Override
    public int FaultYearEight(){
        return faultRecordDatasDao.FaultYearEight();
    }//七天查询第san天
    @Override
    public int FaultYearNine(){
        return faultRecordDatasDao.FaultYearNine();
    }//七天查询第si天
    @Override
    public int FaultYearTen(){
        return faultRecordDatasDao.FaultYearTen();
    }//七天查询第wu天
    @Override
    public int FaultYearEleven(){
        return faultRecordDatasDao.FaultYearEleven();
    }//七天查询第liu天
    @Override
    public int FaultYearTwelve(){
        return faultRecordDatasDao.FaultYearTwelve();
    }//七天查询第qi天
    //预警年查询
    @Override
    public int WarningYearOne(){
        return faultRecordDatasDao.WarningYearOne();
    }//七天查询第一天
    @Override
    public int WarningYearTwo(){
        return faultRecordDatasDao.WarningYearTwo();
    }//七天查询第er天
    @Override
    public int WarningYearThree(){
        return faultRecordDatasDao.WarningYearThree();
    }//七天查询第san天
    @Override
    public int WarningYearFour(){
        return faultRecordDatasDao.WarningYearFour();
    }//七天查询第si天
    @Override
    public int WarningYearFive(){
        return faultRecordDatasDao.WarningYearFive();
    }//七天查询第wu天
    @Override
    public int WarningYearSix(){
        return faultRecordDatasDao.WarningYearSix();
    }//七天查询第liu天
    @Override
    public int WarningYearSeven(){
        return faultRecordDatasDao.WarningYearSeven();
    }//七天查询第qi天
    @Override
    public int WarningYearEight(){
        return faultRecordDatasDao.WarningYearEight();
    }//七天查询第san天
    @Override
    public int WarningYearNine(){
        return faultRecordDatasDao.WarningYearNine();
    }//七天查询第si天
    @Override
    public int WarningYearTen(){
        return faultRecordDatasDao.WarningYearTen();
    }//七天查询第wu天
    @Override
    public int WarningYearEleven(){
        return faultRecordDatasDao.WarningYearEleven();
    }//七天查询第liu天
    @Override
    public int WarningYearTwelve(){
        return faultRecordDatasDao.WarningYearTwelve();
    }//七天查询第qi天

    //故障全部
    @Override
    public int FaultAllOne(){
        return faultRecordDatasDao.FaultAllOne();
    }//七天查询第liu天
    @Override
    public int FaultAllTwo(){
        return faultRecordDatasDao.FaultAllTwo();
    }//七天查询第qi天
    //预警年查询
    @Override
    public int WarnAllOne(){
        return faultRecordDatasDao.WarnAllOne();
    }//七天查询第一天
    @Override
    public int WarnAllTwo(){
        return faultRecordDatasDao.WarnAllTwo();
    }//七天查询第er天
}
