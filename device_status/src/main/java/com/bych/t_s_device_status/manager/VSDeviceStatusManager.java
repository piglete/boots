package com.bych.t_s_device_status.manager;

import club.map.core.manager.GenericManager;
import com.bych.t_s_device_status.model.VSPressureStatusData;

import java.util.List;

public interface VSDeviceStatusManager extends GenericManager<VSPressureStatusData, Integer> {

    /**
     *
     * @param deviceName
     * @param regionCode
     * @param voltageSta
     * @param pressSta
     * @param heartSta
     * @param batterySta
     * @return
     */
    List<VSPressureStatusData> getLastData(String deviceName, String regionCode, Integer voltageSta, Integer pressSta, Integer heartSta, Integer batterySta, Integer deviceSta);

}