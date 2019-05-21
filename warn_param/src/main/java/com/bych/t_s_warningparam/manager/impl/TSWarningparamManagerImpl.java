package com.bych.t_s_warningparam.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import club.map.core.model.FlipFilter;
import club.map.core.model.Operate;
import club.map.core.model.Page;
import com.bych.t_s_device_status.model.TSDeviceStatus;
import com.bych.t_s_warningparam.manager.TSWarningparamManager;
import com.bych.t_s_warningparam.mapper.TSWarningparamMapper;
import com.bych.t_s_warningparam.model.TSWarningparam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class TSWarningparamManagerImpl extends GenericManagerImpl<TSWarningparam, Integer> implements TSWarningparamManager {

    private TSWarningparamMapper tsWarningparamMapper;
    @Autowired
    public TSWarningparamManagerImpl(TSWarningparamMapper mapper,
                                     TSWarningparamMapper tsWarningparamMapper) {
        super(mapper, TSWarningparam.class);
        this.tsWarningparamMapper=tsWarningparamMapper;
    }

    @Override
    public void upperSave(TSWarningparam tsWarningparam) {
        this.save(tsWarningparam);
    }

    @Override
    public Page search(TSWarningparam tsWarningparam, Integer pageNo, Integer pageSize) {
        FlipFilter flipFilter = new FlipFilter(TSWarningparam.class);
        flipFilter.addSearch(tsWarningparam.getPresUpper(), Operate.EQUAL, "");
        flipFilter.addSearch(tsWarningparam.getPresLower(), Operate.EQUAL, "");
        flipFilter.addSearch(tsWarningparam.getVoltageUpper(), Operate.EQUAL, "");
        flipFilter.addSearch(tsWarningparam.getVoltageLower(), Operate.EQUAL, "");
        flipFilter.addSearch(tsWarningparam.getHeartTime(), Operate.EQUAL, "");
        Page page = null;

        //查询时不按部门条件查询时,可以直接查询
        flipFilter.updatePageNo(pageNo);
        flipFilter.setPageSize(pageSize);
        page = this.flipUsingInPage(flipFilter);
        return page;
    }

    @Transactional
    @Override
    public void removeByIds(String ids) {
        String[] idArr = ids.split(",");
        Arrays.asList(idArr).forEach(id -> {
            this.remove(Integer.valueOf(id));
        });
    }

    @Override
    public TSWarningparam searchDetails(Integer id) {
        TSWarningparam tsWarningparam = this.get(id);

        return tsWarningparam;
    }
}