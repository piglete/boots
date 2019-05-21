package com.bych.entity;

public class WarningParam {
    private Integer id;

    private Double presUpper;

    private Double presLower;

    private Double voltageUpper;

    private Double voltageLower;

    private Double heartTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPresUpper() {
        return presUpper;
    }

    public void setPresUpper(Double presUpper) {
        this.presUpper = presUpper;
    }

    public Double getPresLower() {
        return presLower;
    }

    public void setPresLower(Double presLower) {
        this.presLower = presLower;
    }

    public Double getVoltageUpper() {
        return voltageUpper;
    }

    public void setVoltageUpper(Double voltageUpper) {
        this.voltageUpper = voltageUpper;
    }

    public Double getVoltageLower() {
        return voltageLower;
    }

    public void setVoltageLower(Double voltageLower) {
        this.voltageLower = voltageLower;
    }

    public Double getHeartTime() {
        return heartTime;
    }

    public void setHeartTime(Double heartTime) {
        this.heartTime = heartTime;
    }
}