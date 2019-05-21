package com.bych.t_s_warning_record.manager.impl;

import club.map.core.manager.impl.GenericManagerImpl;
import club.map.core.model.FlipFilter;
import club.map.core.model.Operate;
import club.map.core.model.Page;
import com.bych.t_s_warning_record.manager.TSWarningRecordManager;
import com.bych.t_s_warning_record.mapper.TSWarningRecordMapper;
import com.bych.t_s_warning_record.model.TSWarningRecord;
import com.bych.t_s_warning_record.model.VWarnRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TSWarningRecordManagerImpl extends GenericManagerImpl<VWarnRecord, Integer> implements TSWarningRecordManager {

    @Autowired
    public TSWarningRecordManagerImpl(TSWarningRecordMapper mapper) {
        super(mapper, TSWarningRecord.class);
    }

    /**
     * 查询分页方法
     *
     * @param sn
     * @param regionCode
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page search(String sn, String regionCode, Integer pageNo, Integer pageSize) {
        FlipFilter flipFilter = new FlipFilter(VWarnRecord.class);
        flipFilter.addSearch("%"+sn+"%", Operate.LIKE, "sn");
        flipFilter.addSearch("%"+regionCode+"%", Operate.LIKE, "regionCode");
        flipFilter.addSort("warningTime",true);
        Page page = null;

        if (pageSize != null) {
            flipFilter.updatePageNo(pageNo);
            flipFilter.setPageSize(pageSize);
        }

        page = this.flipUsingInPage(flipFilter);
        return page;
    }
}