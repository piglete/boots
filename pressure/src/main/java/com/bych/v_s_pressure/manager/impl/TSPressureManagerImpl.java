package com.bych.v_s_pressure.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import com.bych.v_s_pressure.manager.TSPressureManager;
import com.bych.v_s_pressure.mapper.TSPressureMapper;
import com.bych.v_s_pressure.model.TSPressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class TSPressureManagerImpl extends GenericManagerImpl<TSPressure, Integer> implements TSPressureManager {


    @Autowired
    public TSPressureManagerImpl(TSPressureMapper mapper) {
        super(mapper, TSPressure.class);
    }


    @Transactional
    @Override
    public void removeByIds(String ids) {
        String[] idArr = ids.split(",");
        Arrays.asList(idArr).forEach(id -> {
            this.remove(Integer.valueOf(id));
        });
    }

}