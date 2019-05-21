package com.bych.v_s_pressure.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.v_s_pressure.mapper.sqlprovider.VSPressureProvider;
import com.bych.v_s_pressure.model.VSPressure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface VSPressureMapper extends GenericMapper<VSPressure, Integer> {


    /**
     *
     * @param sn
     * @param deviceName
     * @param regionCode
     * @return
     */
    @SelectProvider(type = VSPressureProvider.class, method = "getLastData")
    List<VSPressure> getLastData(String sn, String deviceName, String regionCode);
}