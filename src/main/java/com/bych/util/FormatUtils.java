package com.bych.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
	public static final String formatDate(Long time){
		if(time == null) return "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date(time)); 
	}
	//获取当前时间的字符串
	public static final String formatDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		return df.format(new Date()); 
	}
	public static final String formatTime(Long time){
		if(time == null) return "";
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date(time)); 
	}
	//截取时间串
	public static final String SubStringTime(String ss){
		if(ss == null) return "";
		ss = ss.substring(0,ss.length() - 2);
		return ss; 
	}
	public static final String formatDateTime(Long time){
		if(time == null) return "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date(time)); 
	}
	public static final Date formatDateTime(String strDate){
		if(strDate == null) return null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] strarray = strDate.split(" ");
		if (strarray.length==1) {
			strDate+=" 00:00:00";
		}
		ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
		
		 return strtodate;
	}
	public static final String formatStrDate(String shortStr){
		if(shortStr == null) return null;
		String[] strarray = shortStr.split(" ");
		if (strarray.length==1) {
			shortStr+=" 00:00:00";
		}
	
		return shortStr;
	}
	/**
	 * 通过时间秒毫秒数判断两个时间的间隔
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDaysByMillisecond(Date date1,Date date2)
	{
		int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
		return days;
	}
}
