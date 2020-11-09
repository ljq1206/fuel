package com.heu.fuel.service.impl;

import com.heu.fuel.dao.FaultEvaluationDao;
import com.heu.fuel.entity.FaultEvaluationFind;
import com.heu.fuel.service.FaultEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultEvaluationServiceImpl implements FaultEvaluationService {
    @Autowired
    FaultEvaluationDao faultEvaluationDao;


    @Override
    public int insertEvaluation(com.heu.fuel.entity.FaultEvaluation faultEvaluation) {
        return faultEvaluationDao.insertEvaluation(faultEvaluation);
    }

    @Override
    public void updateFaultRecord(String id){
        faultEvaluationDao.updateFaultRecord(id);
    }

    @Override
    public int updateFaultEvaluationByFaultRecord() {
        return faultEvaluationDao.updateFaultEvaluationByFaultRecord();
    }

    @Override
    public List<FaultEvaluationFind> findEvaluation(String find_key, String find_value, String sort_key, String sort_value) {
        return faultEvaluationDao.findEvaluation(find_key,find_value,sort_key,sort_value);
    }
}
