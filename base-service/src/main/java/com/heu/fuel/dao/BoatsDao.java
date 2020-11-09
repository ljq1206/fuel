package com.heu.fuel.dao;

import com.heu.fuel.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//2.实体接口

@Mapper
@Repository
public interface BoatsDao {
    public List<Boats> queryAll( String find_key, String find_value, String sort_key, String sort_value);

    public List<BoatsFaultTable> queryFaultTable(String find_key, String find_value, String sort_key, String sort_value, Integer date);

    public List<BoatsWarningTable> queryWarningTable(String find_key, String find_value, String sort_key, String sort_value, Integer date);

    public List<BoatsList> boatsList();//获取船只list

    public int insertBoat(Boats boats);

    public int isExist(Boats boats);

    public int insertBoatStatic(BoatsStatic boatsStatic);

    public int insertFaultStatic(FaultStatic faultStatic);

    public int updateBoat(Boats boats);

    public int GetBoatsFaultCount(@Param("id") Integer id,@Param("date") Integer date);//获取船只故障数量

    public int GetBoatsWarningCount(@Param("id") Integer id,@Param("date") Integer date);//获取船只预警数量

    public List<Integer> GetBoatId();//获取船只id

    public List<Integer> GetFaultId();//获取故障库id

    public int updateFaultStaticByMain();

    public String GetBoatName(@Param("id") Integer id);//获取船只名称

    public List<BoatsAndDevice> GetBoatList();//获取列表

    public List<BoatsAndDevice> GetBoatListCode();//获取列表Code


    public int updateDeviceByBoat();//根据boat更新device

    public int updateDataByBoat();//根据boat更新原始数据

    public int updateFaultRecordByBoat();//根据boat更新故障记录

    public int updateWarningRecordByBoat();//根据boat更新预警记录

    public int updatePreventByBoat();//根据船只更新维护信息

    public int updatePreventRecordByBoat();//根据船只更新维护记录

    public int updatePartByBoat();//根据船只更新备品信息

    public int updatePartChangeByBoat();//根据船只更新备品change

    public int updatePartWarningByBoat();//根据船只更新备品warning

    public int updatePartInoutByBoat();//根据船只更新备品inout

    public int updateBoatSByBoat();//根据船只更新船只统计

    public int updateDeviceSByBoat();//根据船只更新设备统计

    public int deleteBoat(List<String> id);

    public int deleteDeviceByBoat();//根据boat删除device

    public int deleteDataByBoat();//根据boat删除原始数据

    public int deleteFaultRecordByBoat();//根据boat删除故障记录

    public int deleteWarningRecordByBoat();//根据boat删除预警记录

    public int deletePreventByBoat();//根据boat删除维护信息

    public int deletePreventRecordByBoat();//根据boat删除维护记录

    public int deletePartByBoat();//根据boat删除备品信息

    public int deletePartChangeByBoat();//根据boat删除备品change

    public int deletePartWarningByBoat();//根据boat删除备品warning

    public int deletePartInoutByBoat();//根据boat删除备品inout

    public int deleteBoatSByBoat();//根据boat删除船只统计

    public int deleteDeviceSByBoat();//根据boat删除设备统计

    public int deleteFaultSByBoat();//根据boat删除故障统计

    public int GetFaultRecordCountById(@Param("fault_id")int fault_id,@Param("date")int date);
    public int GetFaultRecordCountById1(@Param(value="fault_id")int fault_id,@Param(value="date")int date,int boat_id);
    public int GetBoatsFaultRecordCount(@Param("boat_id")int boat_id,@Param("date")int date);
    public int GetDeviceFaultRecordCount(int device_id,@Param("date")int date);
    public int FaultRecordTotal(@Param("date")int date);
    public int FaultRecordTotal1(@Param(value="date")int date,int boat_id);
    public int updateBoatStatic(Fault_static fault_static);
    public int updateDeviceStatic(Fault_static fault_static);
    public int updateFaultStatic(Fault_static fault_static);

    public int deleteAll();

    public List queryFaultTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);


    public List queryWarningTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);
}

