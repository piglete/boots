package com.bych.v_s_pressure.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("t_s_pressure")
public class TSPressure extends RootObject {
    private Integer equId;//设备id

    private Double pressVal;//压力值

    private Date observeTime;//监测时间

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

    public Date getObserveTime() {
        return observeTime;
    }

    public void setObserveTime(Date observeTime) {
        this.observeTime = observeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equId=").append(equId);
        sb.append(", pressVal=").append(pressVal);
        sb.append(", observeTime=").append(observeTime);
        sb.append("]");
        return sb.toString();
    }
}