package com.bych.t_s_warning_record.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("t_s_warning_record")
public class TSWarningRecord extends RootObject {
    private Integer equId;//设备编号

    private Integer warningValue;//报警值

    private String warningContent;//报警内容

    private Integer deviceStatus;

    private Integer waterLevelStatus;//水位状态

    private Integer batteryStatus;//电池状态

    private Date warningTime;//报警时间

    private Integer ishandle;//信息处理状态

    private Integer gasStatusId;//燃气状态表编号

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public Integer getWarningValue() {
        return warningValue;
    }

    public void setWarningValue(Integer warningValue) {
        this.warningValue = warningValue;
    }

    public String getWarningContent() {
        return warningContent;
    }

    public void setWarningContent(String warningContent) {
        this.warningContent = warningContent;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Integer getWaterLevelStatus() {
        return waterLevelStatus;
    }

    public void setWaterLevelStatus(Integer waterLevelStatus) {
        this.waterLevelStatus = waterLevelStatus;
    }

    public Integer getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(Integer batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
    }

    public Integer getIshandle() {
        return ishandle;
    }

    public void setIshandle(Integer ishandle) {
        this.ishandle = ishandle;
    }

    public Integer getGasStatusId() {
        return gasStatusId;
    }

    public void setGasStatusId(Integer gasStatusId) {
        this.gasStatusId = gasStatusId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equId=").append(equId);
        sb.append(", warningValue=").append(warningValue);
        sb.append(", warningContent=").append(warningContent);
        sb.append(", deviceStatus=").append(deviceStatus);
        sb.append(", waterLevelStatus=").append(waterLevelStatus);
        sb.append(", batteryStatus=").append(batteryStatus);
        sb.append(", warningTime=").append(warningTime);
        sb.append(", ishandle=").append(ishandle);
        sb.append(", gasStatusId=").append(gasStatusId);
        sb.append("]");
        return sb.toString();
    }
}