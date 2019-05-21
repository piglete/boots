package com.bych.t_c_command.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;

import java.util.Date;

@TableName("v_c_command")
public class VCCommand extends RootObject {
    private Integer equId;//设备id

    private Date exeTime;//下发执行时间

    private Integer status;//设备状态

    private Integer exeStatus;//指令执行状态

    private Integer interval;//间隔时间

    private String sn;//设备S/N

    private String name;//设备名称

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public Date getExeTime() {
        return exeTime;
    }

    public void setExeTime(Date exeTime) {
        this.exeTime = exeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExeStatus() {
        return exeStatus;
    }

    public void setExeStatus(Integer exeStatus) {
        this.exeStatus = exeStatus;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equId=").append(equId);
        sb.append(", exeTime=").append(exeTime);
        sb.append(", status=").append(status);
        sb.append(", exeStatus=").append(exeStatus);
        sb.append(", interval=").append(interval);
        sb.append(", sn=").append(sn);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}