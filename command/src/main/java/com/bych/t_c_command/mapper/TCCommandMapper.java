package com.bych.t_c_command.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.t_c_command.mapper.sqlprovider.TCCommandProvider;
import com.bych.t_c_command.model.VCCommand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface TCCommandMapper extends GenericMapper<VCCommand, Integer> {
    @SelectProvider(type = TCCommandProvider.class, method = "search")
    List<VCCommand> search(String sn, String deviceName,Integer deviceSta,Integer exeSta);
}