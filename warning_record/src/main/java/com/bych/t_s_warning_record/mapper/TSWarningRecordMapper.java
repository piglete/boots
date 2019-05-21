package com.bych.t_s_warning_record.mapper;

import club.map.core.mapper.GenericMapper;
import com.bych.t_s_warning_record.model.VWarnRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TSWarningRecordMapper extends GenericMapper<VWarnRecord, Integer> {
}