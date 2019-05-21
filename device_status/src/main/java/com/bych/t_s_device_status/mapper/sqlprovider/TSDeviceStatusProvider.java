package com.bych.t_s_device_status.mapper.sqlprovider;

import club.map.core.mapper.SqlProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TSDeviceStatusProvider extends SqlProvider {
    protected final Log log = LogFactory.getLog(getClass());

    public String getAll(String equId,String name, String equStaBattery, String equStatus,String startDate,String endDate) {
        StringBuffer sb = new StringBuffer(256);
        sb.append("select p.* ");
        sb.append("from t_s_device_status p ");
        sb.append("where p.using_type = 1   ");
        if (!"".equals(equId)) {
            sb.append("and p.equ_id = ").append(equId).append(" ");
        }
        if (!"".equals(name)) {
            sb.append("and p.name like '").append("'%").append(name).append("%' ");
        }
        if (!"".equals(equStaBattery)) {
            sb.append("and p.equ_sta_battery like '").append("'%").append(equStaBattery).append("%' ");
        }
        if (!"".equals(equStatus)) {
            sb.append("and p.equ_sta_battery like '").append("'%").append(equStatus).append("%' ");
        }
        if (!"".equals(startDate) && !"".equals(endDate)) {
            sb.append("and p.equ_sta_time between '").append(startDate).append("' and '").append(endDate).append("' ");
        }
        sb.append("order by p.equ_sta_time desc");
        String sql = sb.toString();
        log.debug(sql);
        return sql;
    }
    public String getLastData(Integer equId, Integer voltageSta, Integer pressSta, Integer heartSta, Integer batterySta,Integer deviceSta) {
        String sql = "select distinct s.id as id,d.name as deviceName,d.sn as sn,d.address as address,s.device_sta as deviceSta,s.supply_voltage as supplyVoltage, s.abnormal_voltage as abnormalVoltage, s.abnormal_press as abnormalPress, s.abnormal_heart as abnormalHeart, s.abnormal_battery as abnormalBattery,max(observe_time) as ObserveTime " +
                " from t_s_pressure_status s,t_b_device d " +
                " where s.equ_id = d.id and s.using_type = 1 and d.using_type = 1 ";
        if (equId != null) {
            sql += " and s.equ_id ="+equId;
        }
        if (voltageSta != null) {
            sql += " and s.abnormal_voltage ="+voltageSta;
        }
        if (pressSta != null) {
            sql += " and s.abnormal_press ="+pressSta;
        }
        if (heartSta != null) {
            sql += " and s.abnormal_heart ="+heartSta;
        }
        if (batterySta != null) {
            sql += " and s.abnormal_battery ="+batterySta;
        }
        if (deviceSta != null) {
            sql += " and s.device_sta ="+deviceSta;
        }
        sql += " group by d.sn order by s.observe_time desc " ;

        return sql;
    }
}