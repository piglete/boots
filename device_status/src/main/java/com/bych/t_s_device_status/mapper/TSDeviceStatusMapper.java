package com.bych.t_s_device_status.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.t_s_device_status.mapper.sqlprovider.TSDeviceStatusProvider;
import com.bych.t_s_device_status.model.TSDeviceStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface TSDeviceStatusMapper extends GenericMapper<TSDeviceStatus, Integer> {

    @SelectProvider(type = TSDeviceStatusProvider.class, method = "getAll")
    List<TSDeviceStatus> getAll(Integer equId, String equStaBattery, String equStatus, String startTime, String endTime);

    @SelectProvider(type = TSDeviceStatusProvider.class, method = "getLastData")
    List<Map<String,Object>> getLastData(Integer equId, Integer voltageSta, Integer pressSta, Integer heartSta, Integer batterySta,Integer deviceSta);
}