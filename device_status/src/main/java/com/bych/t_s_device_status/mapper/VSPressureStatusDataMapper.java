package com.bych.t_s_device_status.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.t_s_device_status.mapper.sqlprovider.VSPressureStatusDataProvider;
import com.bych.t_s_device_status.model.VSPressureStatusData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface VSPressureStatusDataMapper extends GenericMapper<VSPressureStatusData, Integer> {
    @SelectProvider(type = VSPressureStatusDataProvider.class, method = "getLastData")
    List<VSPressureStatusData> getLastData(String deviceName, String regionCode, Integer voltageSta, Integer pressSta, Integer heartSta, Integer batterySta, Integer deviceSta);
}