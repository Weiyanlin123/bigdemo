package com.city.cloud;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author weiyl
 * @date 2020/9/25 16:58
 */
public class SQLFilterUtil {
    static Pattern P = Pattern.compile("[%--`~!@#$^&*()=|{}':;'.<>/?~！@#￥……&*（）——|{}【】‘；：”“'。？]");

    public static boolean getIllegalMatch(String s) {
        Matcher m = P.matcher(s);
        boolean match = m.find();
        return match;
    }





    public static boolean getIllegalMatch(Map<String, Object> map) {
        if(map!=null){
            Collection<Object> values = map.values();
            Iterator<Object> iter = values.iterator() ;
            while(iter.hasNext())
            {
                String str = iter.next().toString();
                Matcher m = P.matcher(str);
                boolean match = m.find();
                return match;
            }
        }
        return false;

    }

    public static boolean getIllegalListMatch(List<String> list) {

        if(list!=null && list.size()>0){
            for(String s: list){
                Matcher m = P.matcher(s);
                boolean match = m.find();
                return match;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        HashMap<String, Object> map = new HashMap<>();
        map.put("aaa",strings);
        boolean illegalMatch = SQLFilterUtil.getIllegalMatch(map);
        boolean listMatch = SQLFilterUtil.getIllegalListMatch(null);

        Student student = new Student();
        System.out.println(strings);
        System.out.println(student);
        System.out.println(illegalMatch);
        System.out.println(listMatch);
    }

}
