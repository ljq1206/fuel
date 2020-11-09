package com.heu.fuel.service.impl;

import com.heu.fuel.dao.BoatsDao;
import com.heu.fuel.entity.*;
import com.heu.fuel.service.BoatsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//4.实现接口

@Service
public class BoatsServicesImpl implements BoatsService {
    @Autowired
    private BoatsDao boatsDao;

    @Override
    public List<Boats> queryAll(String find_key,String find_value,String sort_key,String sort_value) {
        return boatsDao.queryAll(find_key,find_value,sort_key,sort_value);
    }

    @Override
    public List<BoatsFaultTable> queryFaultTable(String find_key, String find_value, String sort_key, String sort_value, Integer date) {
        return boatsDao.queryFaultTable(find_key,find_value,sort_key,sort_value,date);
    }

    @Override
    public List<BoatsWarningTable> queryWarningTable(String find_key, String find_value, String sort_key, String sort_value, Integer date) {
        return boatsDao.queryWarningTable(find_key,find_value,sort_key,sort_value,date);
    }
    @Override
    public int GetBoatsFaultCount(Integer id,Integer date){
        return boatsDao.GetBoatsFaultCount(id,date);
    }//获取船只故障数量

    @Override
    public int GetBoatsWarningCount(Integer id,Integer date){
        return boatsDao.GetBoatsWarningCount(id,date);
    }//获取船只预警数量

    @Override
    public List<Integer> GetBoatId()//获取船只id
    {
        return boatsDao.GetBoatId();
    }

    @Override
    public String GetBoatName(Integer id){
        return boatsDao.GetBoatName(id);
    }//获取船只名称

    @Override
    public List<BoatsList> boatsList(){
        return boatsDao.boatsList();
    }


    @Override
    public List<BoatsAndDevice> GetBoatList(){
        return boatsDao.GetBoatList();
    }

    @Override
    public List<BoatsAndDevice> GetBoatListCode(){
        return boatsDao.GetBoatListCode();
    }

    @Override
    public int insertBoat(Boats boats){
        return boatsDao.insertBoat(boats);
    }

    @Override
    public int isExist(Boats boats) {
        return boatsDao.isExist(boats);
    }

    @Override
    public int insertBoatStatic(BoatsStatic boatsStatic) {
        return boatsDao.insertBoatStatic(boatsStatic);
    }

    @Override
    public int insertFaultStatic(FaultStatic faultStatic) {
        return boatsDao.insertFaultStatic(faultStatic);
    }

    @Override
    public List<Integer> GetFaultId() {
        return boatsDao.GetFaultId();
    }

    @Override
    public int updateFaultStaticByMain() {
        return boatsDao.updateFaultStaticByMain();
    }

    @Override
    public int updateBoat(Boats boats){
        return boatsDao.updateBoat(boats);
    }

    @Override
    public int updateDeviceByBoat(){
        return boatsDao.updateDeviceByBoat();
    }

    @Override
    public int updateDataByBoat(){
        return boatsDao.updateDataByBoat();
    }

    //根据boat更新故障记录
    @Override
    public int updateFaultRecordByBoat(){
        return boatsDao.updateFaultRecordByBoat();
    }

    //根据boat更新预警记录
    @Override
    public int updateWarningRecordByBoat(){
        return boatsDao.updateWarningRecordByBoat();
    }

    @Override
    public int updatePreventByBoat(){
        return boatsDao.updatePreventByBoat();
    }

    @Override
    public int updatePreventRecordByBoat(){
        return boatsDao.updatePreventRecordByBoat();
    }

    @Override
    public int updatePartByBoat(){
        return boatsDao.updatePartByBoat();
    }

    @Override
    public int updatePartChangeByBoat(){
        return boatsDao.updatePartChangeByBoat();
    }

    @Override
    public int updatePartWarningByBoat(){
        return boatsDao.updatePartWarningByBoat();
    }

    @Override
    public int updatePartInoutByBoat(){
        return boatsDao.updatePartInoutByBoat();
    }

    @Override
    public int updateBoatSByBoat(){
        return boatsDao.updateBoatSByBoat();
    }

    @Override
    public int updateDeviceSByBoat(){
        return boatsDao.updateDeviceSByBoat();
    }

    @Override
    public int deleteBoat(List<String> id){
        return boatsDao.deleteBoat(id);
    }

    @Override
    public int deleteDeviceByBoat(){return boatsDao.deleteDeviceByBoat();}

    @Override
    public int deleteDataByBoat(){return boatsDao.deleteDataByBoat();}

    @Override
    public int deleteFaultRecordByBoat(){return boatsDao.deleteFaultRecordByBoat();}

    @Override
    public int deleteWarningRecordByBoat(){return boatsDao.deleteWarningRecordByBoat();}

    @Override
    public int deletePreventByBoat()
    {
        return boatsDao.deletePreventByBoat();
    }

    @Override
    public int deletePreventRecordByBoat(){
        return boatsDao.deletePreventRecordByBoat();
    }

    @Override
    public int deletePartByBoat(){
        return boatsDao.deletePartByBoat();
    }

    @Override
    public int deletePartChangeByBoat(){
        return boatsDao.deletePartChangeByBoat();
    }

    @Override
    public int deletePartWarningByBoat(){
        return boatsDao.deletePartWarningByBoat();
    }

    @Override
    public int deletePartInoutByBoat(){
        return boatsDao.deletePartInoutByBoat();
    }

    @Override
    public int deleteBoatSByBoat(){
        return boatsDao.deleteBoatSByBoat();
    }

    @Override
    public int deleteDeviceSByBoat(){
        return boatsDao.deleteDeviceSByBoat();
    }

    @Override
    public int deleteFaultSByBoat() {
        return boatsDao.deleteFaultSByBoat();
    }

    @Override
    public int GetFaultRecordCountById(int fault_id, int date) {
        return boatsDao.GetFaultRecordCountById(fault_id,date);
    }

    @Override
    public int GetFaultRecordCountById1(int fault_id, int date, int boat_id) {
        return boatsDao.GetFaultRecordCountById1(fault_id,date,boat_id);
    }

    @Override
    public int GetBoatsFaultRecordCount(int boat_id, int date) {
        return boatsDao.GetBoatsFaultRecordCount(boat_id,date);
    }

    @Override
    public int GetDeviceFaultRecordCount(int device_id, int date) {
        return boatsDao.GetDeviceFaultRecordCount(device_id,date);
    }

    @Override
    public int FaultRecordTotal(int date) {
        return boatsDao.FaultRecordTotal(date);
    }

    @Override
    public int FaultRecordTotal1(int date, int boat_id) {
        return boatsDao.FaultRecordTotal1(date,boat_id);
    }

    @Override
    public int updateBoatStatic(Fault_static fault_static) {
        return boatsDao.updateBoatStatic(fault_static);
    }

    @Override
    public int updateDeviceStatic(Fault_static fault_static) {
        return boatsDao.updateDeviceStatic(fault_static);
    }

    @Override
    public int updateFaultStatic(Fault_static fault_static) {
        return boatsDao.updateFaultStatic(fault_static);
    }

    @Override
    public int deleteAll(){
        return boatsDao.deleteAll();
    }

    @Override
    public List queryFaultTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryFaultTableSeven(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryFaultTableMonth(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryFaultTableQuarter(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryFaultTableYear(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryFaultTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryFaultTableAll(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableSeven(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryWarningTableSeven(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableMonth(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryWarningTableMonth(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableQuarter(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryWarningTableQuarter(find_key,find_value,sort_key,sort_value,boat_id);
    }


    @Override
    public List queryWarningTableYear(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryWarningTableYear(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List queryWarningTableAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id){
        return boatsDao.queryWarningTableAll(find_key,find_value,sort_key,sort_value,boat_id);
    }



}

