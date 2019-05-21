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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class TestMain1 {

	static Connection conn1 = null;
	static Connection conn2 = null;
	static PreparedStatement ps1 = null;
	static PreparedStatement ps2 = null;

	public static void main(String[] args) {
		boolean res=transations();

	}

public static boolean transations(){
	try {
		//加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC","root","123456");
		conn1.setAutoCommit(false); //JDBC中默认是true，我们改成false，然后在后面手动提交
		ps1 = conn1.prepareStatement("insert into t_user (username,password) values (?,?)");//?是占位符
		ps1.setObject(1, "张三");
		ps1.setObject(2, "666666");
		ps1.execute();
		System.out.println("给A插入一个用户张三");
		//在提交之前执行事务B
		try{
			conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test2?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC","root","123456");
			conn2.setAutoCommit(false); //JDBC中默认是true，我们改成false，然后在后面手动提交
			ps1 = conn1.prepareStatement("insert into t_user (username,password) values (?,?)");//?是占位符
			ps1.setObject(1, "张四");
			ps1.setObject(2, "666666");
			ps1.execute();
			System.out.println("给B插入一个用户张四");
			conn2.commit();//提交事务B
			conn1.commit();//提交事务A
			return true; //两个事务都成功了
		}catch (Exception e){
			try
			{
				conn2.rollback();//某一条数据添加失败时，回滚
				conn1.rollback();//某一条数据添加失败时，回滚
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		try
		{
			conn1.rollback();//某一条数据添加失败时，回滚
			return false;
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;

	}finally {
		try
		{
			if(ps1!=null)
			{
				ps1.close();
			}
			if(ps2!=null)
			{
				ps2.close();
			}
			if(conn1!=null)
			{
				conn1.close();
			}
			if(conn2!=null)
			{
				conn2.close();
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	return false;
}
}
