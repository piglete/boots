package com.bych.t_s_device_status.mapper.sqlprovider;

import club.map.core.mapper.SqlProvider;
import club.map.core.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class VSPressureStatusDataProvider extends SqlProvider {
    protected final Log log = LogFactory.getLog(getClass());
    public String getLastData(String deviceName, String regionCode, Integer voltageSta, Integer pressSta, Integer heartSta, Integer batterySta, Integer deviceSta) {
        String sql = "select x1.* from v_s_pressure_status x1,(select t.equ_id ,max(t.observe_time) as observe_time from v_s_pressure_status t group by t.equ_id) x2  " +
                "  where x1.equ_id =x2.equ_id and x1.observe_time=x2.observe_time " +
                "  and x1.using_type = 1  ";
        if (!StringUtil.isNull(deviceName)) {
            sql += " and x1.device_name like '"+deviceName+"%'";
        }
        if (!StringUtil.isNull(regionCode)) {
            sql += " and x1.region_code like '"+regionCode+"%'";
        }
        if (voltageSta != null) {
            sql += " and x1.abnormal_voltage ="+voltageSta;
        }
        if (pressSta != null) {
            sql += " and x1.abnormal_press ="+pressSta;
        }
        if (heartSta != null) {
            sql += " and x1.abnormal_heart ="+heartSta;
        }
        if (batterySta != null) {
            sql += " and x1.abnormal_battery ="+batterySta;
        }
        if (deviceSta != null) {
            sql += " and x1.device_sta ="+deviceSta;
        }

        sql += "  order by x1.observe_time desc " ;

        return sql;
    }
}