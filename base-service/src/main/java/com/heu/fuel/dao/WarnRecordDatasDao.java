package com.heu.fuel.dao;

import com.heu.fuel.entity.FaultRecordDatas;
import com.heu.fuel.entity.NotDealWarning;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WarnRecordDatasDao {
    public List<FaultRecordDatas> queryAll(String find_key, String find_value, String sort_key, String sort_value,String boat_id);

    public List<NotDealWarning> NotDealWarning(String find_key, String find_value, String sort_key, String sort_value,String boat_id,String device_code);

    public int isDealWarning(Integer id,String user_id,String username,String deal_time);

    public int isDealWarningSz(int[] id);

    public int NotDealWarningCount();
}
