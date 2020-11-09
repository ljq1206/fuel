package com.heu.fuel.service.impl;

import com.heu.fuel.dao.DeviceDao;
import com.heu.fuel.entity.*;
import com.heu.fuel.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;

    @Override
    public List<Device> queryAll(String find_key, String find_value, String sort_key, String sort_value) {
        return deviceDao.queryAll(find_key,find_value,sort_key,sort_value);
    }

    @Override
    public List<DeviceFaultTable> queryFaultTable(String find_key, String find_value, String sort_key, String sort_value, Integer date) {
        return deviceDao.queryFaultTable(find_key,find_value,sort_key,sort_value,date);
    }

    @Override
    public List<DeviceWarningTable> queryWarningTable(String find_key, String find_value, String sort_key, String sort_value, Integer date) {
        return deviceDao.queryWarningTable(find_key,find_value,sort_key,sort_value,date);
    }

    @Override
    public int GetDeviceFaultCount(Integer id,Integer date){
        return deviceDao.GetDeviceFaultCount(id,date);
    }

    @Override
    public int GetDeviceWarningCount(Integer id,Integer date){
        return deviceDao.GetDeviceWarningCount(id,date);
    }

    @Override
    public List<Integer> GetDeviceId(){
        return deviceDao.GetDeviceId();
    }

    @Override
    public String GetDeviceName(Integer id){
        return deviceDao.GetDeviceName(id);
    }


    @Override
    public int FaultStatus(String device_code){
        return deviceDao.FaultStatus(device_code);
    }

    @Override
    public int WarningStatus(String device_code){
        return deviceDao.WarningStatus(device_code);
    }

    @Override
    public int PreventStatus(String device_code) {
        return deviceDao.PreventStatus(device_code);
    }

    @Override
    public int SparepartStatus(String device_code) {
        return deviceDao.SparepartStatus(device_code);
    }

    @Override
    public int insertDevice(Device device){
        return deviceDao.insertDevice(device);
    }

    @Override
    public int isExist(Device device) {
        return deviceDao.isExist(device);
    }

    @Override
    public int insertDeviceStatic(DeviceStatic deviceStatic) {
        return deviceDao.insertDeviceStatic(deviceStatic);
    }

    @Override
    public int insertMaintenance(PreventDatas preventDatas) {
        return deviceDao.insertMaintenance(preventDatas);
    }

    @Override
    public int updateDevice(Device device){
        return deviceDao.updateDevice(device);
    }

    @Override
    public int updateDeviceByBoat(){
        return deviceDao.updateDeviceByBoat();
    }

    @Override
    public int updateDataByDevice(){
        return deviceDao.updateDataByDevice();
    }

    @Override
    public int updateFaultRecordByDevice(){
        return deviceDao.updateFaultRecordByDevice();
    }

    @Override
    public int updateWarningRecordByDevice(){
        return deviceDao.updateWarningRecordByDevice();
    }

    @Override
    public int updatePreventByDevice(){
        return deviceDao.updatePreventByDevice();
    }

    @Override
    public int updatePreventRecordByDevice(){
        return deviceDao.updatePreventRecordByDevice();
    }

    @Override
    public int updatePartByDevice(){
        return deviceDao.updatePartByDevice();
    }

    @Override
    public int updatePartChangeByDevice(){
        return deviceDao.updatePartChangeByDevice();
    }

    @Override
    public int updatePartWarningByDevice(){
        return deviceDao.updatePartWarningByDevice();
    }

    @Override
    public int updatePartInoutByDevice(){
        return deviceDao.updatePartInoutByDevice();
    }

    @Override
    public int updateDeviceSByDevice(){
        return deviceDao.updateDeviceSByDevice();
    }

    @Override
    public int deleteDevice(String[] device_id){
        return deviceDao.deleteDevice(device_id);
    }

    @Override
    public int deleteDataByDevice(){return deviceDao.deleteDataByDevice();}

    @Override
    public int deleteFaultRecordByDevice(){return deviceDao.deleteFaultRecordByDevice();}

    @Override
    public int deleteWarningRecordByDevice(){return deviceDao.deleteWarningRecordByDevice();}

    @Override
    public int deletePreventByDevice(){
        return deviceDao.deletePreventByDevice();
    }

    @Override
    public int deletePreventRecordByDevice(){
        return deviceDao.deletePreventRecordByDevice();
    }

    @Override
    public int deletePartByDevice(){
        return deviceDao.deletePartByDevice();
    }

    @Override
    public int deletePartChangeByDevice(){
        return deviceDao.deletePartChangeByDevice();
    }

    @Override
    public int deletePartWarningByDevice(){
        return deviceDao.deletePartWarningByDevice();
    }

    @Override
    public int deletePartInoutByDevice(){
        return deviceDao.deletePartInoutByDevice();
    }

    @Override
    public int deleteDeviceSByDevice(){
        return deviceDao.deleteDeviceSByDevice();
    }

    @Override
    public int GetFaultRecordCountById(int fault_id, int date) {
        return deviceDao.GetFaultRecordCountById(fault_id,date);
    }

    @Override
    public int GetFaultRecordCountById1(int fault_id, int date, int boat_id) {
        return deviceDao.GetFaultRecordCountById1(fault_id,date,boat_id);
    }

    @Override
    public int GetBoatsFaultRecordCount(int boat_id, int date) {
        return deviceDao.GetBoatsFaultRecordCount(boat_id,date);
    }

    @Override
    public int GetDeviceFaultRecordCount(int device_id, int date) {
        return deviceDao.GetDeviceFaultRecordCount(device_id,date);
    }

    @Override
    public int FaultRecordTotal(int date) {
        return deviceDao.FaultRecordTotal(date);
    }

    @Override
    public int FaultRecordTotal1(int date, int boat_id) {
        return deviceDao.FaultRecordTotal1(date,boat_id);
    }

    @Override
    public int updateBoatStatic(Fault_static fault_static) {
        return deviceDao.updateBoatStatic(fault_static);
    }

    @Override
    public int updateDeviceStatic(Fault_static fault_static) {
        return deviceDao.updateDeviceStatic(fault_static);
    }

    @Override
    public int updateFaultStatic(Fault_static fault_static) {
        return deviceDao.updateFaultStatic(fault_static);
    }

    @Override
    public int deleteAll(){
        return deviceDao.deleteAll();
    }

    @Override
    public List queryFaultTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryFaultTableSeven(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryFaultTableMonth(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryFaultTableQuarter(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableHalfyear(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryFaultTableHalfyear(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryFaultTableYear(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryFaultTableAll(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryWarningTableSeven(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryWarningTableMonth(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryWarningTableQuarter(find_key,find_value,sort_key,sort_value,boat_id);
    }


    @Override
    public List queryWarningTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryWarningTableYear(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return deviceDao.queryWarningTableAll(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public Set<String> GetNotDealList(String device_code) {
        return deviceDao.GetNotDealList(device_code);
    }

}
