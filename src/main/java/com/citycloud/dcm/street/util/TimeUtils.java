package com.citycloud.dcm.street.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    /**
     * @return : java.lang.String
     * @description 转换日期到字符
     * [date, pattern]
     * @author : dingguangda
     * @date : 2020/2/25 14:42
     */
    public static String formatDateToStr(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * @return : java.util.Date
     * @description 转换日期到日期
     * [date, pattern]
     * @author : dingguangda
     * @date : 2020/2/25 14:45
     */
    public static Date formatDateToDate(Date date, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(date);
        return sdf.parse(dateStr);
    }

    /**
     * @return : java.util.Date
     * @description 格式化日期字符串到日期类
     * [dateStr, pattern]
     * @author : dingguangda
     * @date : 2020/3/12 10:01
     */
    public static Date formatStrToDate(String dateStr, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateStr);
        return date;
    }

    /**
     * 获取两个时间节点的月份差
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static Integer getMonth(LocalDateTime beginTime, LocalDateTime endTime) {
        return Math.abs((endTime.getYear() - beginTime.getYear()) * 12 + endTime.getMonthValue() - beginTime.getMonthValue());
    }

    /**
     * @return : java.util.Calendar
     * @description 通过时间获取日历类
     * [date]
     * @author : dingguangda
     * @date : 2020/4/9 16:04
     */
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * @description 判断是否是同一天
     * [startDate, endDate]
     * @return : boolean
     * @author : dingguangda
     * @date : 2020/4/9 17:16
     */
    public static boolean checkSameDay(Date startDate, Date endDate) {
        boolean sameFlag = false;
        Calendar startCal = getCalendar(startDate);
        Calendar endCal = getCalendar(endDate);
        if (startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR) && startCal.get(Calendar.MONTH) == endCal.get(Calendar.MONTH)) {
            sameFlag = true;
        }
        return sameFlag;
    }

    /**
     * @description 判断是否是昨天
     * [startDate, endDate]
     * @return : boolean
     * @author : dingguangda
     * @date : 2020/4/10 11:20
     */
    public static boolean checkYesterday(Date startDate, Date endDate){
        boolean yesterdayFlag = false;
        Calendar startCal = getCalendar(startDate);
        Calendar endCal = getCalendar(endDate);
        endCal.add(Calendar.DAY_OF_YEAR,-1);
        if (startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR) && startCal.get(Calendar.DAY_OF_YEAR) == endCal.get(Calendar.DAY_OF_YEAR)){
            yesterdayFlag = true;
        }
        return yesterdayFlag;
    }

}
