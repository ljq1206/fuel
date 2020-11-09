package com.heu.fuel.dao;


import com.heu.fuel.entity.FaultEvaluation;
import com.heu.fuel.entity.FaultEvaluationFind;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FaultEvaluationDao {
    public int insertEvaluation(FaultEvaluation faultEvaluation);
    public void updateFaultRecord(String id);

    public int updateFaultEvaluationByFaultRecord();
    public List<FaultEvaluationFind> findEvaluation(String find_key, String find_value, String sort_key, String sort_value);


}
