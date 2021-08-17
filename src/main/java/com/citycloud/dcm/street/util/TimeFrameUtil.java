package com.citycloud.dcm.street.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间范围工具类
 *
 * @author zwq
 *
 */
public class TimeFrameUtil {


	public static void main(String[] args) {
		System.out.println(getToday());
		System.out.println(getCurrentWeek());
		System.out.println(getCurrentMonth());
		System.out.println(getCurrentYear());
	}

	/**
	 * 获取今天的时间范围
	 * @return 返回长度为2的字符串集合，如：[2017-11-03 00:00:00, 2017-11-03 24:00:00]
	 */
	public static List<String> getToday() {
		List<String> dataList = new ArrayList<>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, 0);
		String today = dateFormat.format(calendar.getTime());
		dataList.add(today + " 00:00:00");
		dataList.add(today + " 24:00:00");
		return dataList;
	}

	/**
	 * 获取昨天的时间范围
	 * @return 返回长度为2的字符串集合，如：[2017-11-02 00:00:00, 2017-11-02 24:00:00]
	 */
	public static List<String> getYesterday() {
		List<String> dataList = new ArrayList<>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, -1);
		String yesterday = dateFormat.format(calendar.getTime());
		dataList.add(yesterday + " 00:00:00");
		dataList.add(yesterday + " 24:00:00");
		return dataList;
	}

	/**
	 * 获取本周的时间范围
	 * @return 返回长度为2的字符串集合，如：[2017-10-30 00:00:00, 2017-11-05 24:00:00]
	 */
	public static List<String> getCurrentWeek() {
		List<String> dataList = new ArrayList<>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周之内的第一天
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String monday = dateFormat.format(calendar.getTime()) + " 00:00:00";
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sunday = dateFormat.format(calendar.getTime()) + " 24:00:00";
		dataList.add(monday);
		dataList.add(sunday);
		return dataList;
	}

	/**
	 * 获取本月的时间范围
	 * @return 返回长度为2的字符串集合，如：[2017-11-01 00:00:00, 2017-11-30 24:00:00]
	 */
	public static List<String> getCurrentMonth() {
		List<String> dataList = new ArrayList<>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String firstDayOfMonth = dateFormat.format(calendar.getTime()) + " 00:00:00";
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		String lastDayOfMonth = dateFormat.format(calendar.getTime()) + " 24:00:00";
		dataList.add(firstDayOfMonth);
		dataList.add(lastDayOfMonth);
		return dataList;
	}

	/**
	 * 获取本年的时间范围
	 * @return 返回长度为2的字符串集合，如：[2017-01-01 00:00:00, 2017-12-31 24:00:00]
	 */
	public static List<String> getCurrentYear() {
		List<String> dataList = new ArrayList<>(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.YEAR, 0);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		String firstDayOfYear = dateFormat.format(calendar.getTime()) + " 00:00:00";
		calendar.add(Calendar.YEAR, 1);
		calendar.set(Calendar.DAY_OF_YEAR, 0);
		String lastDayOfYear = dateFormat.format(calendar.getTime()) + " 24:00:00";
		dataList.add(firstDayOfYear);
		dataList.add(lastDayOfYear);
		return dataList;
	}

	public static String formatDateToStr(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

}