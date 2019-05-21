package com.bych.by_b_log.manager;

import com.bych.by_b_log.model.ByBLog;
import club.map.core.manager.GenericManager;
import club.map.core.model.Page;

public interface ByBLogManager extends GenericManager<ByBLog, Integer> {
    Page search(String loginName, String moduleName, String operationName, String ip, Integer pageNo, Integer pageSize);

    void removeByIds(String ids);

    void upperSave(ByBLog sysLog);
}