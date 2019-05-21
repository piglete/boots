package com.bych.t_s_warningparam.manager;

import club.map.core.manager.GenericManager;
import club.map.core.model.Page;
import com.bych.t_s_warningparam.model.TSWarningparam;

public interface TSWarningparamManager extends GenericManager<TSWarningparam, Integer> {
    /**
     * 新增
     *
     * @param tsWarningparam
     * @return
     */
    void upperSave(TSWarningparam tsWarningparam);


    /**
     * 查询分页方法
     * @param tsWarningparam
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page search(TSWarningparam tsWarningparam,Integer pageNo, Integer pageSize);

    /**
     * 批量删除
     *
     * @param ids
     */
    void removeByIds(String ids);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    TSWarningparam searchDetails(Integer id);
}