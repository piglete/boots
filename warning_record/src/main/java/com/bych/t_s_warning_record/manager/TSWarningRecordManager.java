package com.bych.t_s_warning_record.manager;

import club.map.core.manager.GenericManager;
import club.map.core.model.Page;
import com.bych.t_s_warning_record.model.VWarnRecord;

public interface TSWarningRecordManager extends GenericManager<VWarnRecord, Integer> {

    Page search(String sn, String regionCode, Integer pageNo, Integer pageSize);
}