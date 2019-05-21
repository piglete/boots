package com.bych.t_b_device.manager;

import club.map.core.manager.GenericManager;

import club.map.core.model.Page;
import com.bych.t_b_device.model.TBDevice;

import java.util.List;


public interface TBDeviceManager extends GenericManager<TBDevice, Integer> {
    /**
     * 新增
     *
     * @param tbDevice
     * @return
     */
    int upperSave(TBDevice tbDevice);


    /**
     * 查询分页方法
     * @param name
     * @param telecomNumber
     * @param cardNumber
     * @param deviceType
     * @param executionStatus
     * @param pageNo
     * @param pageSize
     * @param startTime
     * @param endTime
     * @return
     */
    Page search(String name,String telecomNumber,String cardNumber,String deviceType,String regionCode,Integer pageNo, Integer pageSize,String startTime,String endTime);


    List<TBDevice> getAll(String name,String telecomNumber,String cardNumber,String regionCode,String deviceType,String executionStatus,String startTime,String endTime);
    /**
     * 批量删除
     *
     * @param ids
     */
    void removeByIds(String ids);

    TBDevice getByTeleCode(String telCode);
    /**
     * 详情
     *
     * @param id
     * @return
     */
    TBDevice searchDetails(Integer id);

    TBDevice searchDetailsWithStatus(Integer id);
}