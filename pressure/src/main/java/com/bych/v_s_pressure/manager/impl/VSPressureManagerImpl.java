package com.bych.v_s_pressure.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import club.map.core.model.FlipFilter;
import club.map.core.model.Operate;
import club.map.core.model.Page;
import com.bych.v_s_pressure.manager.VSPressureManager;
import com.bych.v_s_pressure.mapper.VSPressureMapper;
import com.bych.v_s_pressure.model.VSPressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VSPressureManagerImpl extends GenericManagerImpl<VSPressure, Integer> implements VSPressureManager {

    @Autowired
    private  VSPressureMapper vsPressureMapper;
    @Autowired
    public VSPressureManagerImpl(VSPressureMapper mapper) {
        super(mapper, VSPressure.class);
    }

    @Override
    public Page search(String sn, String deviceName, String regionCode, Integer pageNo, Integer pageSize, String startTime, String endTime) {
        FlipFilter flipFilter = new FlipFilter(VSPressure.class);
        flipFilter.addSearch("%" + sn + "%", Operate.LIKE, "sn");
        flipFilter.addSearch("%" + deviceName + "%", Operate.LIKE, "deviceName");
        flipFilter.addSearch("%" + regionCode + "%", Operate.LIKE, "regionCode");
        Page page = null;
        if (!"".equals(startTime) && !"".equals(endTime)) {
            flipFilter.addRegion("observeTime", startTime, endTime);
        }
        flipFilter.addSort("observeTime",true);
        if (pageSize != null) {
            flipFilter.setPageNo(pageNo);
            flipFilter.setPageSize(pageSize);
        }
        page = this.flipUsingInPage(flipFilter);
        return page;
    }

    @Override
    public List<VSPressure> getLastData(String sn, String deviceName, String regionCode) {
        return vsPressureMapper.getLastData(sn,deviceName,regionCode);
    }


}