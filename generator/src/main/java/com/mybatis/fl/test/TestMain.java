/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.convert
 * @author: lxl
 * @date: 2019年5月10日 下午8:15:25
 */
package com.mybatis.fl.test;

import com.mybatis.fl.entity.BasisInfo;
import com.mybatis.fl.util.EntityInfoUtil;
import com.mybatis.fl.util.Generator;
import com.mybatis.fl.util.MySqlToJavaUtil;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class TestMain {
	//基础信息
	public static final String PROJECT="boots";
	public static final String AUTHOR="lxl";
	public static final String COMPANY="BAOYUE";
	public static final String VERSION="V1.0";
	//数据库连接信息
	public static final String URL="jdbc:mysql://127.0.0.1:3306/bych_qhjk?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
	public static final String NAME="root";
	public static final String PASSWORD="123456";
	public static final String DATABASE="bych_qhjk";
	//类信息
//	public static final String TABLE="t_s_warningparam";
//	public static final String CLASSNAME="WarningParam";
//	public static final String TABLE="t_s_device_status";
//	public static final String CLASSNAME="DeviceStatus";
	public static final String TABLE="t_s_device_status";
	public static final String CLASSNAME="DeviceStatus";
//	public static final String TABLE="t_s_warningparam";
//	public static final String CLASSNAME="WarningParam";
	public static final String CLASSCOMMENT="设备状态";
//	public static final String TIME="2019年05月11日";
	public static final String TIME=LocalDate.now()+"";
	public static final String AGILE=new Date().getTime()+"";
	//路径信息
	public static final String ENTITY_URL="com.bych.entity";
	public static final String DAO_URL="com.bych.dao";
	public static final String XML_URL="com.bych.dao.impl";
	public static final String SERVICE_URL="com.bych.service";
	public static final String SERVICE_IMPL_URL="com.bych.service.impl";
	public static final String CONTROLLER_URL="com.bych.control";
	
	static String classPathRoot;
public void getPath(){
    classPathRoot=this.getClass().getClassLoader().getResource("/").getPath();
}
	public static void main(String[] args) {

		BasisInfo bi=new BasisInfo(PROJECT, AUTHOR,VERSION, URL, NAME, PASSWORD, DATABASE, TIME, AGILE, ENTITY_URL, DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
//		bi.setCompany(COMPANY);
//		bi.setTable(TABLE);
////		bi.setEntityName(MySqlToJavaUtil.getClassName(TABLE));
//		bi.setEntityName(CLASSNAME);
//		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(TABLE));
//		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi=EntityInfoUtil.getInfo(bi);
            String path = System.getProperty("user.dir")+"\\src\\main\\java\\";
			//String mapperPath = System.getProperty("user.dir")+"\\src\\main\\resources\\mapper\\";
//			String aa1=Generator.createEntity(path, bi).toString();
//			String aa2=Generator.createDao(path, bi).toString();
//			String aa3=Generator.createDaoImpl(mapperPath, bi).toString();
//			String aa4=Generator.createService(path, bi).toString();
//			String aa5=Generator.createServiceImpl(path, bi).toString();
			String aa6=Generator.createController(path, bi).toString();
			
//			System.out.println(aa1);
//			System.out.println(aa2);
//			System.out.println(aa3);
//			System.out.println(aa4);
//			System.out.println(aa5);
			System.out.println(aa6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
