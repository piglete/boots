package com.bych.v_s_pressure.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

@TableName("v_s_pressure")
public class VSPressure extends RootObject {
    private String sn;//设备S/N

    private String telecomNumber;//电信编号

    private String deviceName;//设备名称

    private String address;//地址

    private String regionCode;//区域编号

    private Integer equId;//设备id

    private Double pressVal;//压力值

    private String observeTime;//监测时间

    private String installTime;//安装日期

    private Double langitude;//经度

    private String alias;//别名

    private Double latitude;//纬度

    private String regionName;//区域名称

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTelecomNumber() {
        return telecomNumber;
    }

    public void setTelecomNumber(String telecomNumber) {
        this.telecomNumber = telecomNumber;
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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public Double getPressVal() {
        return pressVal;
    }

    public void setPressVal(Double pressVal) {
        this.pressVal = pressVal;
    }

    public String getObserveTime() {
        return observeTime;
    }

    public void setObserveTime(String observeTime) {
        this.observeTime = observeTime;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public Double getLangitude() {
        return langitude;
    }

    public void setLangitude(Double langitude) {
        this.langitude = langitude;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sn=").append(sn);
        sb.append(", telecomNumber=").append(telecomNumber);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", address=").append(address);
        sb.append(", regionCode=").append(regionCode);
        sb.append(", equId=").append(equId);
        sb.append(", pressVal=").append(pressVal);
        sb.append(", observeTime=").append(observeTime);
        sb.append(", installTime=").append(installTime);
        sb.append(", langitude=").append(langitude);
        sb.append(", alias=").append(alias);
        sb.append(", latitude=").append(latitude);
        sb.append(", regionName=").append(regionName);
        sb.append("]");
        return sb.toString();
    }
}