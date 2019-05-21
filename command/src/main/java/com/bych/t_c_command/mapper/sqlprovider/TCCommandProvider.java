package com.bych.t_c_command.mapper.sqlprovider;

import club.map.core.mapper.SqlProvider;
import club.map.core.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TCCommandProvider extends SqlProvider {
    protected final Log log = LogFactory.getLog(getClass());
    public String search(String sn, String deviceName,Integer deviceSta,Integer exeSta) {
        String sql = "select * from v_c_command " +
                "  where using_type = 1  ";
        if (!StringUtil.isNull(sn)) {
            sql += " and sn like '"+sn+"%'";
        }
        if (!StringUtil.isNull(deviceName)) {
            sql += " and device_name like '"+deviceName+"%'";
        }
        if (deviceSta != null) {
            sql += " and status = "+deviceSta;
        }
        if (deviceSta != null) {
            sql += " and exe_status = "+exeSta;
        }
        sql += "  order by exe_time desc ";
        return sql;
    }
}