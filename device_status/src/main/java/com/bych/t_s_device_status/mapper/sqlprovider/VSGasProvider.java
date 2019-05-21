package com.bych.t_s_device_status.mapper.sqlprovider;

import club.map.core.mapper.SqlProvider;
import club.map.core.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class VSGasProvider extends SqlProvider {
    protected final Log log = LogFactory.getLog(getClass());

    public String getLastData(String sn, String deviceName, String regionCode, Integer deviceSta) {
        String sql = "select x1.* from v_s_gas x1,(select t.equ_id ,max(t.observe_time) as observe_time from v_s_gas t group by t.equ_id) x2  " +
                "  where x1.equ_id =x2.equ_id and x1.observe_time=x2.observe_time " +
                "  and x1.using_type = 1  ";
        if (!StringUtil.isNull(sn)) {
            sql += " and x1.sn like '"+sn+"%'";
        }
        if (!StringUtil.isNull(deviceName)) {
            sql += " and x1.device_name like '"+deviceName+"%'";
        }
        if (!StringUtil.isNull(regionCode)) {
            sql += " and x1.region_code like '"+regionCode+"%'";
        }

        if (deviceSta != null) {
            sql += " and x1.device_sta ="+deviceSta;
        }
        sql += "  order by x1.observe_time desc " ;

        return sql;
    }
}