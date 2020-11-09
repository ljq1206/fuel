package com.heu.fuel.dao;

import com.heu.fuel.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Mapper
@Repository
public interface DeviceDao {
    public List<Device> queryAll(String find_key, String find_value, String sort_key, String sort_value);

    public List<DeviceFaultTable> queryFaultTable(String find_key, String find_value, String sort_key, String sort_value, Integer date);

    public List<DeviceWarningTable> queryWarningTable(String find_key, String find_value, String sort_key, String sort_value, Integer date);

    public int FaultStatus(@Param("device_code") String device_code);//设备故障状态

    public int WarningStatus(@Param("device_code") String device_code);//设备预警状态

    public int PreventStatus(@Param("device_code") String device_code);//设备预防性维护状态

    public int SparepartStatus(@Param("device_code") String device_code);//设备备品备件状态

    public int GetDeviceFaultCount(@Param("id") Integer id,@Param("date") Integer date);//获取设备故障数量

    public int GetDeviceWarningCount(@Param("id") Integer id,@Param("date") Integer date);//获取设备预警数量

    public List<Integer> GetDeviceId();//获取设备id

    public String GetDeviceName(@Param("id") Integer id);//获取设备名称

    public int insertDevice(Device device);

    public int isExist(Device device);

    public int insertDeviceStatic(DeviceStatic deviceStatic);

    public int insertMaintenance(PreventDatas preventDatas);

    public int updateDevice(Device device);

    public int updateDeviceByBoat();//根据boat更新device

    public int updateDataByDevice();//根据device更新原始数据

    public int updateFaultRecordByDevice();//根据device更新故障记录

    public int updateWarningRecordByDevice();//根据device更新预警记录

    public int updatePreventByDevice();//根据device更新维护信息

    public int updatePreventRecordByDevice();//根据device更新维护记录

    public int updatePartByDevice();//根据device更新备品信息

    public int updatePartChangeByDevice();//根据device更新备品change

    public int updatePartWarningByDevice();//根据device更新备品warning

    public int updatePartInoutByDevice();//根据device更新备品inout

    public int updateDeviceSByDevice();//根据device更新设备统计

    public int deleteDevice(String[] device_id);

    public int deleteDataByDevice();//根据device删除原始数据

    public int deleteFaultRecordByDevice();//根据device删除故障记录

    public int deleteWarningRecordByDevice();//根据device删除故障记录

    public int deletePreventByDevice();//根据device删除维护信息

    public int deletePreventRecordByDevice();//根据device删除维护记录

    public int deletePartByDevice();//根据device删除备品信息

    public int deletePartChangeByDevice();//根据device删除备品change

    public int deletePartWarningByDevice();//根据device删除备品warning

    public int deletePartInoutByDevice();//根据device删除备品inout

    public int deleteDeviceSByDevice();//根据device删除设备统计

    public int GetFaultRecordCountById(@Param("fault_id")int fault_id,@Param("date")int date);
    public int GetFaultRecordCountById1(@Param(value="fault_id")int fault_id,@Param(value="date")int date,@Param(value="boat_id")int boat_id);
    public int GetBoatsFaultRecordCount(@Param("boat_id")int boat_id,@Param("date")int date);
    public int GetDeviceFaultRecordCount(int device_id,@Param("date")int date);
    public int FaultRecordTotal(@Param("date")int date);
    public int FaultRecordTotal1(@Param(value="date")int date,@Param(value="boat_id")int boat_id);
    public int updateBoatStatic(Fault_static fault_static);
    public int updateDeviceStatic(Fault_static fault_static);
    public int updateFaultStatic(Fault_static fault_static);

    public int deleteAll();

    public List queryFaultTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableHalfyear(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryFaultTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);


    public List queryWarningTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List queryWarningTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public Set<String> GetNotDealList(String device_code);

}
