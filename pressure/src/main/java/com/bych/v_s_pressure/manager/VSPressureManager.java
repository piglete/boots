package com.bych.v_s_pressure.manager;

import club.map.core.manager.GenericManager;
import club.map.core.model.Page;
import com.bych.v_s_pressure.model.VSPressure;

import java.util.List;

public interface VSPressureManager extends GenericManager<VSPressure, Integer> {
    /**
     * 查询分页方法
     * @param sn
     * @param deviceName
     * @param regionCode
     * @param pageNo
     * @param pageSize
     * @param startTime
     * @param endTime
     * @return
     */
    Page search(String sn, String deviceName, String regionCode, Integer pageNo, Integer pageSize, String startTime, String endTime);

    List<VSPressure> getLastData(String sn, String deviceName, String regionCode);
}