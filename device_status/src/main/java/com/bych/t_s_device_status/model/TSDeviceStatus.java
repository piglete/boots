package com.bych.t_s_device_status.model;

import club.map.core.mapper.ColumnTransient;
import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("t_s_pressure_status")
public class TSDeviceStatus extends RootObject {
    private Integer equId;//设备id

    private String equName;//设备名称

    private Date observeTime;//采集/上传时间

    private Double supplyVoltage;//电源电压值

    private Double remained;//电池剩余容量

    private Double singalStrength;//信号强度

    private Integer batterySta;//电池状态

    private Integer wirelessSta;//无线模块状态

    private Integer deviceSta;//设备状态

    private Integer layoutSta;//设备布放状态

    private Integer alarmSta;//设备报警状态

    private Integer coverage;//信号覆盖

    private Integer noiseRatio;//信噪比

    private Integer temperature;//设备温度

    private Integer abnormalVoltage;//电压异常

    private Integer abnormalPress;//压力异常

    private Integer abnormalHeart;//心跳异常

    private Integer abnormalBattery;//电池异常

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public Date getObserveTime() {
        return observeTime;
    }

    public void setObserveTime(Date observeTime) {
        this.observeTime = observeTime;
    }

    public Double getSupplyVoltage() {
        return supplyVoltage;
    }

    public void setSupplyVoltage(Double supplyVoltage) {
        this.supplyVoltage = supplyVoltage;
    }

    public Double getRemained() {
        return remained;
    }

    public void setRemained(Double remained) {
        this.remained = remained;
    }

    public Double getSingalStrength() {
        return singalStrength;
    }

    public void setSingalStrength(Double singalStrength) {
        this.singalStrength = singalStrength;
    }

    public Integer getBatterySta() {
        return batterySta;
    }

    public void setBatterySta(Integer batterySta) {
        this.batterySta = batterySta;
    }

    public Integer getWirelessSta() {
        return wirelessSta;
    }

    public void setWirelessSta(Integer wirelessSta) {
        this.wirelessSta = wirelessSta;
    }

    public Integer getDeviceSta() {
        return deviceSta;
    }

    public void setDeviceSta(Integer deviceSta) {
        this.deviceSta = deviceSta;
    }

    public Integer getLayoutSta() {
        return layoutSta;
    }

    public void setLayoutSta(Integer layoutSta) {
        this.layoutSta = layoutSta;
    }

    public Integer getAlarmSta() {
        return alarmSta;
    }

    public void setAlarmSta(Integer alarmSta) {
        this.alarmSta = alarmSta;
    }

    public Integer getCoverage() {
        return coverage;
    }

    public void setCoverage(Integer coverage) {
        this.coverage = coverage;
    }

    public Integer getNoiseRatio() {
        return noiseRatio;
    }

    public void setNoiseRatio(Integer noiseRatio) {
        this.noiseRatio = noiseRatio;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
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

    @ColumnTransient
    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equId=").append(equId);
        sb.append(", observeTime=").append(observeTime);
        sb.append(", supplyVoltage=").append(supplyVoltage);
        sb.append(", remained=").append(remained);
        sb.append(", singalStrength=").append(singalStrength);
        sb.append(", batterySta=").append(batterySta);
        sb.append(", wirelessSta=").append(wirelessSta);
        sb.append(", deviceSta=").append(deviceSta);
        sb.append(", layoutSta=").append(layoutSta);
        sb.append(", alarmSta=").append(alarmSta);
        sb.append(", coverage=").append(coverage);
        sb.append(", noiseRatio=").append(noiseRatio);
        sb.append(", temperature=").append(temperature);
        sb.append(", abnormalVoltage=").append(abnormalVoltage);
        sb.append(", abnormalPress=").append(abnormalPress);
        sb.append(", abnormalHeart=").append(abnormalHeart);
        sb.append(", abnormalBattery=").append(abnormalBattery);
        sb.append("]");
        return sb.toString();
    }
}