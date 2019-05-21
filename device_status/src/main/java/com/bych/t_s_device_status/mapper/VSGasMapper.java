package com.bych.t_s_device_status.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.t_s_device_status.mapper.sqlprovider.VSGasProvider;
import com.bych.t_s_device_status.model.VSGas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface VSGasMapper extends GenericMapper<VSGas, Integer> {
    @SelectProvider(type = VSGasProvider.class, method = "getLastData")
    List<VSGas> getLastData(String sn, String deviceName, String regionCode, Integer deviceSta);
}