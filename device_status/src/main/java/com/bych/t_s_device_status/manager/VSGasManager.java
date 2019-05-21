package com.bych.t_s_device_status.manager;

import club.map.core.manager.GenericManager;
import com.bych.t_s_device_status.model.VSGas;
import com.github.pagehelper.PageInfo;

public interface VSGasManager extends GenericManager<VSGas, Integer> {
    PageInfo getLastData(String sn, String deviceName, String regionCode, Integer deviceSta, Integer pageNo, Integer pageSize);
}