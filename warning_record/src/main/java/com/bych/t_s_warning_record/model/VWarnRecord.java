package com.bych.t_s_warning_record.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("v_warn_record")
public class VWarnRecord extends RootObject {
    private Integer equId;//设备编号

    private Integer warningValue;//报警值

    private String warningContent;//报警内容

    private Integer deviceStatus;

    private Integer ishandle;//信息处理状态(0:未确认,1:已确认)

    private String sn;//设备S/N

    private String cardNumber;//卡号

    private String deviceName;//设备名称

    private String address;//地址

    private Integer waterLevelStatus;//水位状态

    private Integer batteryStatus;//电池状态

    private Date warningTime;//报警时间

    private String regionName;//区域名称

    private String alias;//别名

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

    public Integer getIshandle() {
        return ishandle;
    }

    public void setIshandle(Integer ishandle) {
        this.ishandle = ishandle;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
        sb.append(", ishandle=").append(ishandle);
        sb.append(", sn=").append(sn);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", address=").append(address);
        sb.append(", waterLevelStatus=").append(waterLevelStatus);
        sb.append(", batteryStatus=").append(batteryStatus);
        sb.append(", warningTime=").append(warningTime);
        sb.append(", regionName=").append(regionName);
        sb.append(", alias=").append(alias);
        sb.append("]");
        return sb.toString();
    }
}