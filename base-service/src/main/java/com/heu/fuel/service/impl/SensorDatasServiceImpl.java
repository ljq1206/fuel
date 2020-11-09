package com.heu.fuel.service.impl;

import com.heu.fuel.dao.SensorDatasDao;
import com.heu.fuel.entity.SensorDatas;
import com.heu.fuel.service.SensorDatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDatasServiceImpl implements SensorDatasService {
    @Autowired
    private SensorDatasDao sensorDatasDao;

    @Override
    public List<SensorDatas> queryAll(String device_code,List<String> fault_data_id, String start_time,String end_time, String sort_key, String sort_value) {
        return sensorDatasDao.queryAll(device_code,fault_data_id,start_time,end_time,sort_key,sort_value);
    }

    @Override
    public int Boat_total(){
        return sensorDatasDao.Boat_total();
    }
    @Override
    public int Device_total(){
        return sensorDatasDao.Device_total();
    }
    @Override
    public int Fault_type_total(){
        return sensorDatasDao.Fault_type_total();
    }
    @Override
    public int Fault__total(){
        return sensorDatasDao.Fault__total();
    }
    @Override
    public int Warning_total(){
        return sensorDatasDao.Warning_total();
    }

    //故障7天查询
    @Override
    public int FaultSevenOne(){
        return sensorDatasDao.FaultSevenOne();
    }//七天查询第一天
    @Override
    public int FaultSevenTwo(){
        return sensorDatasDao.FaultSevenTwo();
    }//七天查询第er天
    @Override
    public int FaultSevenThree(){
        return sensorDatasDao.FaultSevenThree();
    }//七天查询第san天
    @Override
    public int FaultSevenFour(){
        return sensorDatasDao.FaultSevenFour();
    }//七天查询第si天
    @Override
    public int FaultSevenFive(){
        return sensorDatasDao.FaultSevenFive();
    }//七天查询第wu天
    @Override
    public int FaultSevenSix(){
        return sensorDatasDao.FaultSevenSix();
    }//七天查询第liu天
    @Override
    public int FaultSevenSeven(){
        return sensorDatasDao.FaultSevenSeven();
    }//七天查询第qi天

    //预警7天查询
    @Override
    public int WarningSevenOne(){
        return sensorDatasDao.WarningSevenOne();
    }//七天查询第一天
    @Override
    public int WarningSevenTwo(){
        return sensorDatasDao.WarningSevenTwo();
    }//七天查询第er天
    @Override
    public int WarningSevenThree(){
        return sensorDatasDao.WarningSevenThree();
    }//七天查询第san天
    @Override
    public int WarningSevenFour(){
        return sensorDatasDao.WarningSevenFour();
    }//七天查询第si天
    @Override
    public int WarningSevenFive(){
        return sensorDatasDao.WarningSevenFive();
    }//七天查询第wu天
    @Override
    public int WarningSevenSix(){
        return sensorDatasDao.WarningSevenSix();
    }//七天查询第liu天
    @Override
    public int WarningSevenSeven(){
        return sensorDatasDao.WarningSevenSeven();
    }//七天查询第qi天
    //船只7天查询
    public int BoatSevenOne(){
        return sensorDatasDao.BoatSevenOne();
    }//七天查询第一天
    public int BoatSevenTwo(){
        return sensorDatasDao.BoatSevenTwo();
    }//七天查询第er天
    public int BoatSevenThree(){
        return sensorDatasDao.BoatSevenThree();
    }//七天查询第san天
    public int BoatSevenFour(){
        return sensorDatasDao.BoatSevenFour();
    }//七天查询第si天
    public int BoatSevenFive(){
        return sensorDatasDao.BoatSevenFive();
    }//七天查询第wu天
    public int BoatSevenSix(){
        return sensorDatasDao.BoatSevenSix();
    }//七天查询第liu天
    public int BoatSevenSeven(){
        return sensorDatasDao.BoatSevenSeven();
    }//七天查询第qi天
    //设备7天查询
    public int DeviceSevenOne(){
        return sensorDatasDao.DeviceSevenOne();
    }//七天查询第一天
    public int DeviceSevenTwo(){
        return sensorDatasDao.DeviceSevenTwo();
    }//七天查询第er天
    public int DeviceSevenThree(){
        return sensorDatasDao.DeviceSevenThree();
    }//七天查询第san天
    public int DeviceSevenFour(){
        return sensorDatasDao.DeviceSevenFour();
    }//七天查询第si天
    public int DeviceSevenFive(){
        return sensorDatasDao.DeviceSevenFive();
    }//七天查询第wu天
    public int DeviceSevenSix(){
        return sensorDatasDao.DeviceSevenSix();
    }//七天查询第liu天
    public int DeviceSevenSeven(){
        return sensorDatasDao.DeviceSevenSeven();
    }//七天查询第qi天

    //故障月查询
    @Override
    public int FaultMonthOne(){
        return sensorDatasDao.FaultMonthOne();
    }//查询第一周
    @Override
    public int FaultMonthTwo(){
        return sensorDatasDao.FaultMonthTwo();
    }//查询第er周
    @Override
    public int FaultMonthThree(){
        return sensorDatasDao.FaultMonthThree();
    }//查询第san周
    @Override
    public int FaultMonthFour(){
        return sensorDatasDao.FaultMonthFour();
    }//查询第si周
    //预警月查询
    @Override
    public int WarningMonthOne(){
        return sensorDatasDao.WarningMonthOne();
    }//查询第一周
    @Override
    public int WarningMonthTwo(){
        return sensorDatasDao.WarningMonthTwo();
    }//查询第er周
    @Override
    public int WarningMonthThree(){
        return sensorDatasDao.WarningMonthThree();
    }//查询第san周
    @Override
    public int WarningMonthFour(){
        return sensorDatasDao.WarningMonthFour();
    }//查询第si周
    //船只月查询
    @Override
    public int BoatMonthOne(){
        return sensorDatasDao.BoatMonthOne();
    }//查询第一周
    @Override
    public int BoatMonthTwo(){
        return sensorDatasDao.BoatMonthTwo();
    }//查询第er周
    @Override
    public int BoatMonthThree(){
        return sensorDatasDao.BoatMonthThree();
    }//查询第san周
    @Override
    public int BoatMonthFour(){
        return sensorDatasDao.BoatMonthFour();
    }//查询第si周
    //设备月查询
    @Override
    public int DeviceMonthOne(){
        return sensorDatasDao.DeviceMonthOne();
    }//查询第一周
    @Override
    public int DeviceMonthTwo(){
        return sensorDatasDao.DeviceMonthTwo();
    }//查询第er周
    @Override
    public int DeviceMonthThree(){
        return sensorDatasDao.DeviceMonthThree();
    }//查询第san周
    @Override
    public int DeviceMonthFour(){
        return sensorDatasDao.DeviceMonthFour();
    }//查询第si周

    //故障季度查询
    @Override
    public int FaultSeasonOne(){
        return sensorDatasDao.FaultSeasonOne();
    }//查询第一周
    @Override
    public int FaultSeasonTwo(){
        return sensorDatasDao.FaultSeasonTwo();
    }//查询第er周
    @Override
    public int FaultSeasonThree(){
        return sensorDatasDao.FaultSeasonThree();
    }//查询第san周
    @Override
    public int FaultSeasonFour(){
        return sensorDatasDao.FaultSeasonFour();
    }//查询第si周
    //预警季度查询
    @Override
    public int WarningSeasonOne(){
        return sensorDatasDao.WarningSeasonOne();
    }//查询第一周
    @Override
    public int WarningSeasonTwo(){
        return sensorDatasDao.WarningSeasonTwo();
    }//查询第er周
    @Override
    public int WarningSeasonThree(){
        return sensorDatasDao.WarningSeasonThree();
    }//查询第san周
    @Override
    public int WarningSeasonFour(){
        return sensorDatasDao.WarningSeasonFour();
    }//查询第si周
    //船只季度查询
    @Override
    public int BoatSeasonOne(){
        return sensorDatasDao.BoatSeasonOne();
    }//查询第一周
    @Override
    public int BoatSeasonTwo(){
        return sensorDatasDao.BoatSeasonTwo();
    }//查询第er周
    @Override
    public int BoatSeasonThree(){
        return sensorDatasDao.BoatSeasonThree();
    }//查询第san周
    @Override
    public int BoatSeasonFour(){
        return sensorDatasDao.BoatSeasonFour();
    }//查询第si周
    //设备季度查询
    @Override
    public int DeviceSeasonOne(){
        return sensorDatasDao.DeviceSeasonOne();
    }//查询第一周
    @Override
    public int DeviceSeasonTwo(){
        return sensorDatasDao.DeviceSeasonTwo();
    }//查询第er周
    @Override
    public int DeviceSeasonThree(){
        return sensorDatasDao.DeviceSeasonThree();
    }//查询第san周
    @Override
    public int DeviceSeasonFour(){
        return sensorDatasDao.DeviceSeasonFour();
    }//查询第si周



    //故障年查询
    @Override
    public int FaultYearOne(){
        return sensorDatasDao.FaultYearOne();
    }//查询第一月
    @Override
    public int FaultYearTwo(){
        return sensorDatasDao.FaultYearTwo();
    }//查询第er月
    @Override
    public int FaultYearThree(){
        return sensorDatasDao.FaultYearThree();
    }//查询第san
    @Override
    public int FaultYearFour(){
        return sensorDatasDao.FaultYearFour();
    }//查询第si
    @Override
    public int FaultYearFive(){
        return sensorDatasDao.FaultYearFive();
    }//查询第5月
    @Override
    public int FaultYearSix(){
        return sensorDatasDao.FaultYearSix();
    }//查询第6月
    @Override
    public int FaultYearSeven(){
        return sensorDatasDao.FaultYearSeven();
    }//查询第7
    @Override
    public int FaultYearEight(){
        return sensorDatasDao.FaultYearEight();
    }//查询第8
    @Override
    public int FaultYearNine(){
        return sensorDatasDao.FaultYearNine();
    }//查询第9月
    @Override
    public int FaultYearTen(){
        return sensorDatasDao.FaultYearTen();
    }//查询第10月
    @Override
    public int FaultYearEleven(){
        return sensorDatasDao.FaultYearEleven();
    }//查询第11
    @Override
    public int FaultYearTwelve(){
        return sensorDatasDao.FaultYearTwelve();
    }//查询第12
    //预警年查询
    @Override
    public int WarningYearOne(){
        return sensorDatasDao.WarningYearOne();
    }//查询第一
    @Override
    public int WarningYearTwo(){
        return sensorDatasDao.WarningYearTwo();
    }//查询第er
    @Override
    public int WarningYearThree(){
        return sensorDatasDao.WarningYearThree();
    }//第san
    @Override
    public int WarningYearFour(){
        return sensorDatasDao.WarningYearFour();
    }//查询第si
    @Override
    public int WarningYearFive(){
        return sensorDatasDao.WarningYearFive();
    }//查询第5
    @Override
    public int WarningYearSix(){
        return sensorDatasDao.WarningYearSix();
    }//查询第6
    @Override
    public int WarningYearSeven(){
        return sensorDatasDao.WarningYearSeven();
    }//第7
    @Override
    public int WarningYearEight(){
        return sensorDatasDao.WarningYearEight();
    }//查询第8
    @Override
    public int WarningYearNine(){
        return sensorDatasDao.WarningYearNine();
    }//查询第9
    @Override
    public int WarningYearTen(){
        return sensorDatasDao.WarningYearTen();
    }//查询第10
    @Override
    public int WarningYearEleven(){
        return sensorDatasDao.WarningYearEleven();
    }//第11
    @Override
    public int WarningYearTwelve(){
        return sensorDatasDao.WarningYearTwelve();
    }//查询第12
    //船只年查询
    @Override
    public int BoatYearOne(){
        return sensorDatasDao.BoatYearOne();
    }//查询第一
    @Override
    public int BoatYearTwo(){
        return sensorDatasDao.BoatYearTwo();
    }//查询第er
    @Override
    public int BoatYearThree(){
        return sensorDatasDao.BoatYearThree();
    }//查询第san
    @Override
    public int BoatYearFour(){
        return sensorDatasDao.BoatYearFour();
    }//查询第si
    @Override
    public int BoatYearFive(){
        return sensorDatasDao.BoatYearFive();
    }//查询第5
    @Override
    public int BoatYearSix(){
        return sensorDatasDao.BoatYearSix();
    }//查询第6
    @Override
    public int BoatYearSeven(){
        return sensorDatasDao.BoatYearSeven();
    }//查询第7
    @Override
    public int BoatYearEight(){
        return sensorDatasDao.BoatYearEight();
    }//查询第8
    @Override
    public int BoatYearNine(){
        return sensorDatasDao.BoatYearNine();
    }//查询第9
    @Override
    public int BoatYearTen(){
        return sensorDatasDao.BoatYearTen();
    }//查询第10
    @Override
    public int BoatYearEleven(){
        return sensorDatasDao.BoatYearEleven();
    }//查询第11
    @Override
    public int BoatYearTwelve(){
        return sensorDatasDao.BoatYearTwelve();
    }//查询第12
    //设备年查询
    @Override
    public int DeviceYearOne(){
        return sensorDatasDao.DeviceYearOne();
    }//查询第一
    @Override
    public int DeviceYearTwo(){
        return sensorDatasDao.DeviceYearTwo();
    }//查询第er
    @Override
    public int DeviceYearThree(){
        return sensorDatasDao.DeviceYearThree();
    }//第san
    @Override
    public int DeviceYearFour(){
        return sensorDatasDao.DeviceYearFour();
    }//查询第si
    @Override
    public int DeviceYearFive(){
        return sensorDatasDao.DeviceYearFive();
    }//查询第5
    @Override
    public int DeviceYearSix(){
        return sensorDatasDao.DeviceYearSix();
    }//查询第6
    @Override
    public int DeviceYearSeven(){
        return sensorDatasDao.DeviceYearSeven();
    }//第7
    @Override
    public int DeviceYearEight(){
        return sensorDatasDao.DeviceYearEight();
    }//查询第8
    @Override
    public int DeviceYearNine(){
        return sensorDatasDao.DeviceYearNine();
    }//查询第9
    @Override
    public int DeviceYearTen(){
        return sensorDatasDao.DeviceYearTen();
    }//查询第10
    @Override
    public int DeviceYearEleven(){
        return sensorDatasDao.DeviceYearEleven();
    }//第11
    @Override
    public int DeviceYearTwelve(){
        return sensorDatasDao.DeviceYearTwelve();
    }//查询第12


    //故障all查询
    @Override
    public int FaultAllOne(){
        return sensorDatasDao.FaultAllOne();
    }//查询第一年
    @Override
    public int FaultAllTwo(){
        return sensorDatasDao.FaultAllTwo();
    }//查询第er年
    //预警all查询
    @Override
    public int WarningAllOne(){
        return sensorDatasDao.WarningAllOne();
    }//查询第一
    @Override
    public int WarningAllTwo(){
        return sensorDatasDao.WarningAllTwo();
    }//查询第er
    //船只all查询
    @Override
    public int BoatAllOne(){
        return sensorDatasDao.BoatAllOne();
    }//查询第一
    @Override
    public int BoatAllTwo(){
        return sensorDatasDao.BoatAllTwo();
    }//查询第er
    //设备all查询
    @Override
    public int DeviceAllOne(){
        return sensorDatasDao.DeviceAllOne();
    }//查询第一
    @Override
    public int DeviceAllTwo(){
        return sensorDatasDao.DeviceAllTwo();
    }//查询第er
}
