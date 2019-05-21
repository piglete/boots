package com.bych.t_s_device_status.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("v_s_gas")
public class VSGas extends RootObject {
    private Integer equId;//设备id

    private Date observeTime;//采集/上传时间

    private Integer sensorSta;//传感器状态

    private Integer deviceSta;//传感器状态

    private Float gassChroma;//可燃气体浓度

    private Integer waterLevelSta;//水位状态

    private String sn;//设备S/N

    private String cardNumber;//卡号

    private String deviceName;//设备名称

    private String regionCode;//区域编号

    private String alias;//别名

    private String regionName;//区域名称

    public Integer getBatterySta() {
        return batterySta;
    }

    public void setBatterySta(Integer batterySta) {
        this.batterySta = batterySta;
    }

    private Integer batterySta;//电池状态

    private String address;//安装地址
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

    public Integer getSensorSta() {
        return sensorSta;
    }

    public void setSensorSta(Integer sensorSta) {
        this.sensorSta = sensorSta;
    }

    public Float getGassChroma() {
        return gassChroma;
    }

    public void setGassChroma(Float gassChroma) {
        this.gassChroma = gassChroma;
    }

    public Integer getWaterLevelSta() {
        return waterLevelSta;
    }

    public void setWaterLevelSta(Integer waterLevelSta) {
        this.waterLevelSta = waterLevelSta;
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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public Integer getDeviceSta() {
        return deviceSta;
    }

    public void setDeviceSta(Integer deviceSta) {
        this.deviceSta = deviceSta;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equId=").append(equId);
        sb.append(", observeTime=").append(observeTime);
        sb.append(", sensorSta=").append(sensorSta);
        sb.append(", gassChroma=").append(gassChroma);
        sb.append(", waterLevelSta=").append(waterLevelSta);
        sb.append(", sn=").append(sn);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", regionCode=").append(regionCode);
        sb.append(", alias=").append(alias);
        sb.append(", regionName=").append(regionName);
        sb.append("]");
        return sb.toString();
    }
}