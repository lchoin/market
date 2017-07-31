package com.jzf.market.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	
	/**
	 * 判断指定日期是否超过指定分钟
	 * @param date	指定时间
	 * @param assignMinute	指定分钟
	 * @return	超过返回 true
	 */
	public static boolean isDateExceed(Date date,int assignMinute){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, assignMinute);
		
		Date exceedDate = calendar.getTime();
		System.out.println("指定时间+5 " + exceedDate);
		Date currentDate = new Date();
		System.out.println("当前时间 " + currentDate);
		return !currentDate.before(exceedDate);
	}
	
//	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		System.out.println(isDateExceed(sdf.parse("2016-12-08 10:50:59"),5));
//	}
}
