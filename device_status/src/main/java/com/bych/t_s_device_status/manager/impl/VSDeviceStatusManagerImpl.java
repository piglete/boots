package com.bych.t_s_device_status.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import com.bych.t_s_device_status.manager.VSDeviceStatusManager;
import com.bych.t_s_device_status.mapper.VSPressureStatusDataMapper;
import com.bych.t_s_device_status.model.VSPressureStatusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VSDeviceStatusManagerImpl extends GenericManagerImpl<VSPressureStatusData, Integer> implements VSDeviceStatusManager {

    @Autowired
    private VSPressureStatusDataMapper vsPressureStatusDataMapper;

    @Autowired
    public VSDeviceStatusManagerImpl(VSPressureStatusDataMapper mapper

    ) {
        super(mapper, VSPressureStatusData.class);

    }


    @Override
    public List<VSPressureStatusData> getLastData(String deviceName, String regionCode, Integer voltageSta, Integer pressSta, Integer heartSta, Integer batterySta, Integer deviceSta) {
        return vsPressureStatusDataMapper.getLastData(deviceName,regionCode,voltageSta,pressSta,heartSta,batterySta,deviceSta);
    }
}