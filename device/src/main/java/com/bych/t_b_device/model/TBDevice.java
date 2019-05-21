package com.bych.t_b_device.model;

import club.map.core.mapper.ColumnTransient;
import club.map.core.model.RootObject;
import club.map.core.model.TableName;

@TableName("t_b_device")
public class TBDevice extends RootObject {
    private String sn;//设备S/N

    private String telecomNumber;//电信编号

    private String cardNumber;//卡号

    private Integer deviceType;//设备类型

    private String name;//设备名称

    private String address;//地址

    private String regionCode;//区域编号

    private Double langitude;//经度

    private Double latitude;//纬度

    private String installTime;//安装日期

    private String produceTime;//生产日期
	    

    private String regionName;//区域名称


    private String regionAlias;//区域别名

    private String category;

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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getLangitude() {
        return langitude;
    }

    public void setLangitude(Double langitude) {
        this.langitude = langitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @ColumnTransient
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    @ColumnTransient
    public String getRegionAlias() {
        return regionAlias;
    }

    public void setRegionAlias(String regionAlias) {
        this.regionAlias = regionAlias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sn=").append(sn);
        sb.append(", telecomNumber=").append(telecomNumber);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", regionCode=").append(regionCode);
        sb.append(", langitude=").append(langitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", installTime=").append(installTime);
        sb.append(", produceTime=").append(produceTime);
        sb.append(", category=").append(category);
        sb.append("]");
        return sb.toString();
    }
}