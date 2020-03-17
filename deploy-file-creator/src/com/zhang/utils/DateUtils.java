package com.zhang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String yyyyMMdd = "yyyyMMdd";

	public static String defaultPattern = "yyyy-MM-dd HH:mm:ss";
	
	public static String getCurrentDateStr() {
		return dateToString(new Date(), yyyyMMddHHmmss);
	}

	/**
	 * 时间转化为字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, defaultPattern);
	}

	/**
	 * 时间转化为字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		if (StringUtils.isStrObjBlank(pattern)) {
			pattern = defaultPattern;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateStr = simpleDateFormat.format(date);
		return dateStr;
	}

	/**
	 * 字符串转化为时间
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String dateStr) {
		return stringToDate(dateStr, defaultPattern);
	}

	/**
	 * 字符串转化为时间
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String dateStr, String pattern) {
		if (StringUtils.isStrObjBlank(pattern)) {
			pattern = defaultPattern;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		String s = dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
		System.out.println(s);
		
		Date d = stringToDate("2015-12-12 10:01:01");
		System.out.println(d);
	}
}
