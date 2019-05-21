/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.util
 * @author: lxl
 * @date: 2019年5月10日 下午8:15:25
 */
package com.mybatis.fl.util;

import com.mybatis.fl.entity.BasisInfo;
import com.mybatis.fl.entity.PropertyInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明：  链接数据库并获取表信息</P>
 * @version: v2.1.0
 * @author: lxl
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2019年5月10日      		lxl   v2.1.0           initialize
 */
public class EntityInfoUtil {
	public static BasisInfo getInfo(BasisInfo bi) throws SQLException {
		List<PropertyInfo> columns= new ArrayList<PropertyInfo>();
		// 创建连接
		Connection con = null;
		PreparedStatement pstemt = null;
		//sql
		String sql="select column_name,data_type,column_comment from information_schema.columns where table_schema='"+bi.getDatabase()+"' and table_name='"+bi.getTable()+"'";
		try {
			con = DriverManager.getConnection(bi.getDbUrl(), bi.getDbName(), bi.getDbPassword());
			pstemt = con.prepareStatement(sql);
			ResultSet executeQuery = pstemt.executeQuery();
			while (executeQuery.next()) {
				String column = executeQuery.getString(1);
				String jdbcType = executeQuery.getString(2);
				String comment = executeQuery.getString(3);
				PropertyInfo ci=new PropertyInfo();
				ci.setColumn(column);
				if (jdbcType.equalsIgnoreCase("int")) {
					ci.setJdbcType("Integer");
				}else if (jdbcType.equalsIgnoreCase("datetime")) {
					ci.setJdbcType("timestamp");
				}else {
					ci.setJdbcType(jdbcType);
				}
				ci.setComment(comment);
				ci.setProperty(MySqlToJavaUtil.changeToJavaFiled(column));
				ci.setJavaType(MySqlToJavaUtil.jdbcTypeToJavaType(jdbcType));
				//设置注解类型
				if (column.equalsIgnoreCase("id")) {
					bi.setIdType(ci.getJavaType());
					bi.setIdJdbcType(ci.getJdbcType());
				}
				columns.add(ci);
			}
			bi.setCis(columns);
			return bi;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("自动生成实体类错误："+e.getMessage());
		} finally {
			pstemt.close();
			con.close();
		}
	}
}
