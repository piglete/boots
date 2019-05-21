package com.bych.t_s_device_status.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("v_s_pressure_status")
public class VSPressureStatusData extends RootObject {
    private Double supplyVoltage;//电源电压值

    private Date observeTime;//采集/上传时间

    private Integer abnormalVoltage;//电压异常

    private Integer abnormalPress;//压力异常

    private Integer abnormalHeart;//心跳异常

    private Integer abnormalBattery;//电池异常



    private Integer deviceSta;//设备状态

    private String sn;//设备S/N

    private String deviceName;//设备名称

    private String address;//地址

    private String regionName;//区域名称

    private String alias;//别名

    private String regionCode;//区域编号

    public Double getSupplyVoltage() {
        return supplyVoltage;
    }

    public void setSupplyVoltage(Double supplyVoltage) {
        this.supplyVoltage = supplyVoltage;
    }

    public Date getObserveTime() {
        return observeTime;
    }

    public void setObserveTime(Date observeTime) {
        this.observeTime = observeTime;
    }

    public Integer getAbnormalVoltage() {
        return abnormalVoltage;
    }

    public void setAbnormalVoltage(Integer abnormalVoltage) {
        this.abnormalVoltage = abnormalVoltage;
    }

    public Integer getAbnormalPress() {
        return abnormalPress;
    }

    public void setAbnormalPress(Integer abnormalPress) {
        this.abnormalPress = abnormalPress;
    }

    public Integer getAbnormalHeart() {
        return abnormalHeart;
    }

    public void setAbnormalHeart(Integer abnormalHeart) {
        this.abnormalHeart = abnormalHeart;
    }

    public Integer getAbnormalBattery() {
        return abnormalBattery;
    }

    public void setAbnormalBattery(Integer abnormalBattery) {
        this.abnormalBattery = abnormalBattery;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
    public Integer getDeviceSta() {
        return deviceSta;
    }

    public void setDeviceSta(Integer deviceSta) {
        this.deviceSta = deviceSta;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplyVoltage=").append(supplyVoltage);
        sb.append(", observeTime=").append(observeTime);
        sb.append(", abnormalVoltage=").append(abnormalVoltage);
        sb.append(", abnormalPress=").append(abnormalPress);
        sb.append(", abnormalHeart=").append(abnormalHeart);
        sb.append(", abnormalBattery=").append(abnormalBattery);
        sb.append(", deviceSta=").append(deviceSta);
        sb.append(", sn=").append(sn);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", address=").append(address);
        sb.append(", regionName=").append(regionName);
        sb.append(", alias=").append(alias);
        sb.append(", regionCode=").append(regionCode);
        sb.append("]");
        return sb.toString();
    }
}