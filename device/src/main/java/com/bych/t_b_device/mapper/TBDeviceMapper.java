package com.bych.t_b_device.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.t_b_device.mapper.sqlprovider.TBDeviceProvider;
import com.bych.t_b_device.model.TBDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface TBDeviceMapper extends GenericMapper<TBDevice, Integer> {

    @SelectProvider(type = TBDeviceProvider.class, method = "getAll")
    List<TBDevice> getAll(String name, String telecomNumber, String cardNumber,String regionCode, String deviceType, String executionStatus, String startTime, String endTime);

    @Select("select id from t_b_device where telecom_number like CONCAT('%',#{telCode},'%')")
    TBDevice getByTeleCode(String telCode);
}