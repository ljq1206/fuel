package com.heu.fuel.dao;

import com.heu.fuel.entity.SensorDatas;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SensorDatasDao {
    public List<SensorDatas> queryAll(String device_code,List<String> fault_data_id, String start_time,String end_time, String sort_key, String sort_value);

    public int Boat_total(); //船只总数
    public int Device_total(); //设备总数
    public int Fault_type_total(); //故障类型总数
    public int Fault__total();  //故障总数
    public int Warning_total();  //预警总数

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
    //船只7天查询
    public int BoatSevenOne();//七天查询第一天
    public int BoatSevenTwo();//七天查询第er天
    public int BoatSevenThree();//七天查询第san天
    public int BoatSevenFour();//七天查询第si天
    public int BoatSevenFive();//七天查询第wu天
    public int BoatSevenSix();//七天查询第liu天
    public int BoatSevenSeven();//七天查询第qi天
    //设备7天查询
    public int DeviceSevenOne();//七天查询第一天
    public int DeviceSevenTwo();//七天查询第er天
    public int DeviceSevenThree();//七天查询第san天
    public int DeviceSevenFour();//七天查询第si天
    public int DeviceSevenFive();//七天查询第wu天
    public int DeviceSevenSix();//七天查询第liu天
    public int DeviceSevenSeven();//七天查询第qi天

    //故障月查询
    public int FaultMonthOne();//查询第一周
    public int FaultMonthTwo();//查询第er周
    public int FaultMonthThree();//查询第san周
    public int FaultMonthFour();//查询第si周
    //预警月查询
    public int WarningMonthOne();//查询第一周
    public int WarningMonthTwo();//查询第er周
    public int WarningMonthThree();//查询第san周
    public int WarningMonthFour();//查询第si周
    //船只月查询
    public int BoatMonthOne();//查询第一周
    public int BoatMonthTwo();//查询第er周
    public int BoatMonthThree();//查询第san周
    public int BoatMonthFour();//查询第si周
    //设备月查询
    public int DeviceMonthOne();//查询第一
    public int DeviceMonthTwo();//查询第er
    public int DeviceMonthThree();//查询第san
    public int DeviceMonthFour();//查询第si

    //故障季度查询
    public int FaultSeasonOne();//查询第一周
    public int FaultSeasonTwo();//查询第er周
    public int FaultSeasonThree();//查询第san周
    public int FaultSeasonFour();//查询第si周
    //预警季度查询
    public int WarningSeasonOne();//查询第一周
    public int WarningSeasonTwo();//查询第er周
    public int WarningSeasonThree();//查询第san周
    public int WarningSeasonFour();//查询第si周
    //船只季度查询
    public int BoatSeasonOne();//查询第一周
    public int BoatSeasonTwo();//查询第er周
    public int BoatSeasonThree();//查询第san周
    public int BoatSeasonFour();//查询第si周
    //设备季度查询
    public int DeviceSeasonOne();//查询第一
    public int DeviceSeasonTwo();//查询第er
    public int DeviceSeasonThree();//查询第san
    public int DeviceSeasonFour();//查询第si

    //故障年查询
    public int FaultYearOne();//查询第一月
    public int FaultYearTwo();//查询第er月
    public int FaultYearThree();//查询第san
    public int FaultYearFour();//查询第si
    public int FaultYearFive();//查询第wu
    public int FaultYearSix();//查询第liu
    public int FaultYearSeven();//查询第qi
    public int FaultYearEight();//查询第8
    public int FaultYearNine();//查询第9
    public int FaultYearTen();//查询第wu10
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
    //船只年查询
    public int BoatYearOne();//查询第一
    public int BoatYearTwo();//查询第er
    public int BoatYearThree();//查询第san
    public int BoatYearFour();//查询第si
    public int BoatYearFive();//查询第wu
    public int BoatYearSix();//查询第liu
    public int BoatYearSeven();//查询第qi
    public int BoatYearEight();//查询第8
    public int BoatYearNine();//查询第9
    public int BoatYearTen();//查询第10
    public int BoatYearEleven();//查询第11
    public int BoatYearTwelve();//查询第12
    //设备年查询
    public int DeviceYearOne();//查询第一
    public int DeviceYearTwo();//查询第er
    public int DeviceYearThree();//查询第san
    public int DeviceYearFour();//查询第si
    public int DeviceYearFive();//查询第wu
    public int DeviceYearSix();//查询第liu
    public int DeviceYearSeven();//查询第qi
    public int DeviceYearEight();//查询第8
    public int DeviceYearNine();//查询第9
    public int DeviceYearTen();//询第10
    public int DeviceYearEleven();//查询第11
    public int DeviceYearTwelve();//查询第12

    //故障all查询
    public int FaultAllOne();//查询第一年
    public int FaultAllTwo();//查询第er年
    //预警all查询
    public int WarningAllOne();//查询第一
    public int WarningAllTwo();//查询第er
    //船只all查询
    public int BoatAllOne();//查询第一
    public int BoatAllTwo();//查询第er
    //设备all查询
    public int DeviceAllOne();//查询第一
    public int DeviceAllTwo();//查询第er

}
