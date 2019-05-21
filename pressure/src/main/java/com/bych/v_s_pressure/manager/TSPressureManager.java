package com.bych.v_s_pressure.manager;

import club.map.core.manager.GenericManager;
import com.bych.v_s_pressure.model.TSPressure;

public interface TSPressureManager extends GenericManager<TSPressure, Integer> {

    /**
     * 批量删除
     *
     * @param ids
     */
    void removeByIds(String ids);
}