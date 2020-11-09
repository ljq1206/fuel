package com.heu.fuel.service.impl;

import com.heu.fuel.dao.WarnRecordDatasDao;
import com.heu.fuel.entity.FaultRecordDatas;
import com.heu.fuel.entity.NotDealWarning;
import com.heu.fuel.service.WarnRecordDatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarnRecordDatasServiceImpl implements WarnRecordDatasService {
    @Autowired
    WarnRecordDatasDao warnRecordDatasDao;

    @Override
    public List<FaultRecordDatas> queryAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id) {
        return warnRecordDatasDao.queryAll(find_key,find_value,sort_key,sort_value,boat_id);
    }

    @Override
    public List<NotDealWarning> NotDealWarning(String find_key, String find_value, String sort_key, String sort_value,String boat_id,String device_code) {
        return warnRecordDatasDao.NotDealWarning(find_key,find_value,sort_key,sort_value,boat_id,device_code);
    }

    @Override
    public int isDealWarning(Integer id,String user_id,String username,String deal_time){
        return warnRecordDatasDao.isDealWarning(id,user_id,username,deal_time);
    }

    @Override
    public int isDealWarningSz(int[] id){
        return warnRecordDatasDao.isDealWarningSz(id);
    }

    @Override
    public int NotDealWarningCount(){
        return warnRecordDatasDao.NotDealWarningCount();
    }
}
