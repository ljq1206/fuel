package com.heu.fuel.dao;

import com.heu.fuel.entity.FaultRecordDatas;
import com.heu.fuel.entity.NotDealFault;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FaultRecordDatasDao {
    public List<FaultRecordDatas> queryAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List<NotDealFault> NotDealFault(String find_key, String find_value, String sort_key, String sort_value,String boat_id,String device_code);

    public int isDealFault(Integer id);

    public int isDealFaultSz(int[] id);

    public int NotDealFaultCount();  //获取当前未处理故障数量
    public int DealFaultCount();  //获取当前已处理故障数量
    public int FaultTotal();  //获取当前已处理故障数量

    public int NotDealFaultCount(@Param("device_code") String device_code);  //获取当前设备未处理故障数量
    public int DealFaultCount(@Param("device_code") String device_code);  //获取当前设备已处理故障数量
    public int FaultTotal(@Param("device_code") String device_code);  //获取当前设备已处理故障数量
//故障7天查询
    public int FaultSevenOne();//七天查询第一天
    public int FaultSevenTwo();//七天查询第er天
    public int FaultSevenThree();//七天查询第san天
    public int FaultSevenFour();//七天查询第si天
    public int FaultSevenFive();//七天查询第wu天
    public int FaultSevenSix();//七天查询第liu天
    public int FaultSevenSeven();//七天查询第qi天
    //预警7天查询
    public int WarningSevenOne();//七天查询第一天
    public int WarningSevenTwo();//七天查询第er天
    public int WarningSevenThree();//七天查询第san天
    public int WarningSevenFour();//七天查询第si天
    public int WarningSevenFive();//七天查询第wu天
    public int WarningSevenSix();//七天查询第liu天
    public int WarningSevenSeven();//七天查询第qi天

    //故障月查询
    public int FaultMonthOne();//月查询第一周
    public int FaultMonthTwo();//月查询第二周
    public int FaultMonthThree();//月查询第三周
    public int FaultMonthFour();//月查询第四周
    //预警月查询
    public int WarnMonthOne();//月查询第一周
    public int WarnMonthTwo();//月查询第二周
    public int WarnMonthThree();//月查询第三周
    public int WarnMonthFour();//月查询第四周

    //故障季度查询
    public int FaultSeasonOne();//季度查询第一
    public int FaultSeasonTwo();//季度查询第二
    public int FaultSeasonThree();//季度查询第三
    public int FaultSeasonFour();//季度查询第四
    //预警季度查询
    public int WarnSeasonOne();//季度查询第一
    public int WarnSeasonTwo();//季度查询第二
    public int WarnSeasonThree();//季度查询第三
    public int WarnSeasonFour();//季度查询第四

    //故障年查询
    public int FaultYearOne();//查询第一月
    public int FaultYearTwo();//查询第er月
    public int FaultYearThree();//查询第san月
    public int FaultYearFour();//查询第si
    public int FaultYearFive();//查询第wu
    public int FaultYearSix();//查询第liu
    public int FaultYearSeven();//查询第qi
    public int FaultYearEight();//查询第8
    public int FaultYearNine();//查询第9
    public int FaultYearTen();//查询第10
    public int FaultYearEleven();//查询第11
    public int FaultYearTwelve();//查询第12
    //预警年查询
    public int WarningYearOne();//查询第一
    public int WarningYearTwo();//查询第er
    public int WarningYearThree();//查询第san
    public int WarningYearFour();//查询第si
    public int WarningYearFive();//查询第wu
    public int WarningYearSix();//查询第liu
    public int WarningYearSeven();//查询第qi
    public int WarningYearEight();//查询第8
    public int WarningYearNine();//查询第9
    public int WarningYearTen();//查询第10
    public int WarningYearEleven();//查询第11
    public int WarningYearTwelve();//查询第12

    //故障全部
    public int FaultAllOne();//季度查询第一
    public int FaultAllTwo();//季度查询第二
    //预警全部
    public int WarnAllOne();//季度查询第一
    public int WarnAllTwo();//季度查询第二


}
