package com.heu.fuel.service;


import com.heu.fuel.entity.FaultEvaluation;
import com.heu.fuel.entity.FaultEvaluationFind;

import java.util.List;

public interface FaultEvaluationService {
    public int insertEvaluation(FaultEvaluation faultEvaluation);
    public void updateFaultRecord(String id);

    public int updateFaultEvaluationByFaultRecord();
    public List<FaultEvaluationFind> findEvaluation(String find_key, String find_value, String sort_key, String sort_value);

}
