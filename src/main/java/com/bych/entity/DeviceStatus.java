package com.bych.entity;

import java.util.Date;

public class DeviceStatus {
    private Integer id;

    private String equId;

    private Date equStaTime;

    private Double equStaVoltage;

    private Double equStaRemaining;

    private Double equStaSingal;

    private String equStaBattery;

    private String equStatus;

    private String equStaWireless;

    private String equStaLayout;

    private String equStaAlarm;

    private String equStaCoverage;

    private String equStaNoise;

    private String equStaTemp;

    private String equAbnormalVoltage;

    private String equAbnormalPress;

    private String equAbnormalHeart;

    private String equAbnormalBattery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquId() {
        return equId;
    }

    public void setEquId(String equId) {
        this.equId = equId == null ? null : equId.trim();
    }

    public Date getEquStaTime() {
        return equStaTime;
    }

    public void setEquStaTime(Date equStaTime) {
        this.equStaTime = equStaTime;
    }

    public Double getEquStaVoltage() {
        return equStaVoltage;
    }

    public void setEquStaVoltage(Double equStaVoltage) {
        this.equStaVoltage = equStaVoltage;
    }

    public Double getEquStaRemaining() {
        return equStaRemaining;
    }

    public void setEquStaRemaining(Double equStaRemaining) {
        this.equStaRemaining = equStaRemaining;
    }

    public Double getEquStaSingal() {
        return equStaSingal;
    }

    public void setEquStaSingal(Double equStaSingal) {
        this.equStaSingal = equStaSingal;
    }

    public String getEquStaBattery() {
        return equStaBattery;
    }

    public void setEquStaBattery(String equStaBattery) {
        this.equStaBattery = equStaBattery == null ? null : equStaBattery.trim();
    }

    public String getEquStatus() {
        return equStatus;
    }

    public void setEquStatus(String equStatus) {
        this.equStatus = equStatus == null ? null : equStatus.trim();
    }

    public String getEquStaWireless() {
        return equStaWireless;
    }

    public void setEquStaWireless(String equStaWireless) {
        this.equStaWireless = equStaWireless == null ? null : equStaWireless.trim();
    }

    public String getEquStaLayout() {
        return equStaLayout;
    }

    public void setEquStaLayout(String equStaLayout) {
        this.equStaLayout = equStaLayout == null ? null : equStaLayout.trim();
    }

    public String getEquStaAlarm() {
        return equStaAlarm;
    }

    public void setEquStaAlarm(String equStaAlarm) {
        this.equStaAlarm = equStaAlarm == null ? null : equStaAlarm.trim();
    }

    public String getEquStaCoverage() {
        return equStaCoverage;
    }

    public void setEquStaCoverage(String equStaCoverage) {
        this.equStaCoverage = equStaCoverage == null ? null : equStaCoverage.trim();
    }

    public String getEquStaNoise() {
        return equStaNoise;
    }

    public void setEquStaNoise(String equStaNoise) {
        this.equStaNoise = equStaNoise == null ? null : equStaNoise.trim();
    }

    public String getEquStaTemp() {
        return equStaTemp;
    }

    public void setEquStaTemp(String equStaTemp) {
        this.equStaTemp = equStaTemp == null ? null : equStaTemp.trim();
    }

    public String getEquAbnormalVoltage() {
        return equAbnormalVoltage;
    }

    public void setEquAbnormalVoltage(String equAbnormalVoltage) {
        this.equAbnormalVoltage = equAbnormalVoltage == null ? null : equAbnormalVoltage.trim();
    }

    public String getEquAbnormalPress() {
        return equAbnormalPress;
    }

    public void setEquAbnormalPress(String equAbnormalPress) {
        this.equAbnormalPress = equAbnormalPress == null ? null : equAbnormalPress.trim();
    }

    public String getEquAbnormalHeart() {
        return equAbnormalHeart;
    }

    public void setEquAbnormalHeart(String equAbnormalHeart) {
        this.equAbnormalHeart = equAbnormalHeart == null ? null : equAbnormalHeart.trim();
    }

    public String getEquAbnormalBattery() {
        return equAbnormalBattery;
    }

    public void setEquAbnormalBattery(String equAbnormalBattery) {
        this.equAbnormalBattery = equAbnormalBattery == null ? null : equAbnormalBattery.trim();
    }
}