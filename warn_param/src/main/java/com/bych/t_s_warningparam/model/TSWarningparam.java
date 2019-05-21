package com.bych.t_s_warningparam.model;

import club.map.core.model.RootObject;
import club.map.core.model.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_s_warningparam")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel()
public class TSWarningparam extends RootObject {
    private Double presUpper;//压力上限

    private Double presLower;//压力下限

    private Double voltageUpper;//电压上限

    private Double voltageLower;//电压下限

    private Double heartTime;//心跳包时间

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", presUpper=").append(presUpper);
        sb.append(", presLower=").append(presLower);
        sb.append(", voltageUpper=").append(voltageUpper);
        sb.append(", voltageLower=").append(voltageLower);
        sb.append(", heartTime=").append(heartTime);
        sb.append("]");
        return sb.toString();
    }
}