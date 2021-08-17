package com.citycloud.dcm.street.util;

import com.citycloud.dcm.street.param.Source;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        String nestMonth = getThisMonth();;
        Integer.parseInt(nestMonth.substring(0,4));
        ;
        System.out.println(Integer.parseInt(nestMonth.substring(4,6)));
        String day = formatDateToStr(new Date(), "yyyy-MM-dd");
        System.out.println(day);
        String month = formatDateToStr(new Date(), "yyyy-MM");
        System.out.println(month);
        System.out.println("==================================================================================");
        List<String> weekDateList = getWeekDateList();
        for (String s : weekDateList){
            System.out.println(s);
              if(day.equals(s)){
              break;
              }
        }

        List<String> monthFullDay = getMonthFullDay(Integer.parseInt(nestMonth.substring(0, 4)), Integer.parseInt(nestMonth.substring(4, 6)), 01);
        System.out.println("==================================================================================");
       for (String s : monthFullDay){
           System.out.println(s);
           if(day.equals(s)){
               break;
           }
       }

        //  System.out.println(getWeekDateList());
      //  System.out.println(getMonthFullDay(Integer.parseInt(nestMonth.substring(0,4)), Integer.parseInt(nestMonth.substring(4,6)),01));
     //   System.out.print(getThisYearMonths());
        System.out.println("==================================================================================");
        for (String s : getThisYearMonths()){
            System.out.println(s);
            if(month.equals(s)){
                break;
            }
        }

//        String[] last12Months = new String[12];
//        Calendar cal = Calendar.getInstance();
//        //如果当前日期大于二月份的天数28天或者29天会导致计算月份错误，会多出一个三月份，故设置一个靠前日期解决此问题
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        for (int i = 0; i < 12; i++) {
//            last12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
//            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
//        }
//        for (int i = 0; i < last12Months.length; i++) {
//            System.out.println(last12Months[i]);
//        }

    }

    public static List<String> getMonthFullDay(int year , int month, int day){
        List<String> fullDayList = new ArrayList<String>();
        if(day <= 0 ) day = 1;
        Calendar cal = Calendar.getInstance();// 获得当前日期对象
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// 1月从0开始
        cal.set(Calendar.DAY_OF_MONTH, day);// 设置为1号,当前日期既为本月第一天
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j <= (count-1);) {
            if(sdf.format(cal.getTime()).equals(getLastDay(year, month)))
                break;
            cal.add(Calendar.DAY_OF_MONTH, j == 0 ? +0 : +1);
            j++;
            fullDayList.add(sdf.format(cal.getTime()));
        }
        return fullDayList;
    }

    public static String getLastDay(int year,int month){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return sdf.format(cal.getTime());
    }

    public static String getNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }
    public static String getThisMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }

    /**
     * 获取当前日期所在的周一到周日的所有日期集合
     * @return
     */
    public static List<String> getWeekDateList() {
        Calendar cal = Calendar.getInstance();
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(dayWeek==1){
            dayWeek = 8;
        }

        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);
        Date mondayDate = cal.getTime();

        cal.add(Calendar.DATE, 4 +cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();

        List lDate = new ArrayList();

        lDate.add(formatDateToStr(mondayDate,"yyyy-MM-dd"));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(mondayDate);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(sundayDate);
        //测试此日期是否在指定日期之后
        while (sundayDate.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(formatDateToStr(calBegin.getTime(),"yyyy-MM-dd"));
        }
        return lDate;}


    public static String formatDateToStr(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    public static List<String> getThisYearMonths(){
        //建一个容器
        List<String> months=new ArrayList<>();
        //获取日历对象
        Calendar calendar = Calendar.getInstance();

        //调整到12个月以前
        String nestMonth = getThisMonth();;
        int currentMonth = Integer.parseInt(nestMonth.substring(4, 6));
        calendar.add(Calendar.MONTH,-currentMonth+1);
        //循环12次获取12个月份
        //当前月份
        for (int i = 0; i < currentMonth; i++) {
            //日历对象转为Date对象
            Date date = calendar.getTime();
            //将date转为字符串
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String dateStr = sdf.format(date);
            //向list集合中添加
            months.add(dateStr);
            //每次月份+1
            calendar.add(Calendar.MONTH,1);
        }
        return months;
    }


}