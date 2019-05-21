package com.bych.t_s_device_status.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import com.bych.t_s_device_status.manager.VSGasManager;
import com.bych.t_s_device_status.mapper.VSGasMapper;
import com.bych.t_s_device_status.model.VSGas;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VSGasManagerImpl extends GenericManagerImpl<VSGas, Integer> implements VSGasManager {

    @Autowired
    public VSGasManagerImpl(VSGasMapper mapper) {
        super(mapper, VSGas.class);
    }
    @Autowired
    private VSGasMapper vsGasMapper;
    @Override
    public PageInfo getLastData(String sn, String deviceName, String regionCode, Integer deviceSta, Integer pageNo, Integer pageSize) {
        if (pageSize != null) {
            PageHelper.startPage(pageNo,pageSize);
        }
        List<VSGas> docs=vsGasMapper.getLastData(sn,deviceName,regionCode,deviceSta);
        PageInfo page= new PageInfo<>(docs);

        return page;
    }
}