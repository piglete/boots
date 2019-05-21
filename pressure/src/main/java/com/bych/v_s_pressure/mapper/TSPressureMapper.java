package com.bych.v_s_pressure.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.v_s_pressure.model.TSPressure;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TSPressureMapper extends GenericMapper<TSPressure, Integer> {

}