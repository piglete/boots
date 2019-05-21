package com.bych.t_b_device.mapper.sqlprovider;

import club.map.core.mapper.SqlProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TBDeviceProvider extends SqlProvider {
    protected final Log log = LogFactory.getLog(getClass());
    public String getAll(String name, String telecomNumber, String cardNumber,String regionCode, String deviceType, String executionStatus, String startTime, String endTime) {
        StringBuffer sb = new StringBuffer(256);
        sb.append("select p.*,r.name as regionName,r.full_name as regionFullName   ");
        sb.append("from t_b_device p,by_b_region r   ");
        sb.append("where p.using_type = 1   ");
        sb.append("and p.region_code = r.code   ");
        if (!"".equals(name)) {
            sb.append("and p.name like ").append("'%").append(name).append("%' ");
        }
        if (!"".equals(telecomNumber)) {
            sb.append("and p.telecom_number like ").append("'%").append(telecomNumber).append("%' ");
        }
        if (!"".equals(cardNumber)) {
            sb.append("and p.card_number like ").append("'%").append(cardNumber).append("%' ");
        }
        if (!"".equals(regionCode)) {
            sb.append("and p.region_code like ").append("'%").append(regionCode).append("%' ");
        }
        if (!"".equals(deviceType)) {
            sb.append("and p.device_type like ").append("'%").append(deviceType).append("%' ");
        }
        if (!"".equals(executionStatus)) {
            sb.append("and p.execution_status like ").append("'%").append(executionStatus).append("%' ");
        }
        if (!"".equals(startTime) && !"".equals(endTime)) {
            sb.append("and p.install_time between '").append(startTime).append("' and '").append(endTime).append("' ");
        }
        sb.append("order by p.install_time desc");
        String sql = sb.toString();
        log.debug(sql);
        return sql;
    }
}