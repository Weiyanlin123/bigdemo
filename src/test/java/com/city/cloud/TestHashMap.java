package com.city.cloud;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHashMap {


    public static void main(String[] args) {



String url="http://172.18.16.15/szcg/ali/getMediaStream/rec/20210323/5331148397/a6780052-768d-45ed-a98a-288ee19d56c7/1616451175009.jpg?objName=rec/20210323/5331148397/a6780052-768d-45ed-a98a-288ee19d56c7/1616451175009.jpg?1616483983342";

        String ip = getIp(url);
        String substring = url.substring(url.indexOf(ip)+ip.length(), url.length());
        System.out.println(url.indexOf(ip));
        System.out.println(ip);
        System.out.println(substring);


        String b[] = {"1q","aa","cc"};

        String a[] = {"1asd"};
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<a.length;i++){
            stringBuffer.append(b[i]);
            stringBuffer.append("|");
        }
        System.out.println(stringBuffer.substring(0,stringBuffer.length()-1));





        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("aaa","aaab");
        objectObjectHashMap.put("vvv","aava");
        objectObjectHashMap.get("1");

        Instant now = Instant.now();

        System.out.println(now);
        System.out.println(Instant.ofEpochMilli(11111111));
        System.out.println(Instant.ofEpochSecond(111111111));


        Set<Map.Entry<Object, Object>> entries = objectObjectHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> it = entries.iterator();

        while (it.hasNext()){
            Map.Entry<Object, Object> next = it.next();
            System.out.println(next.getKey()+"================"+next.getValue());
        }

        for(Object key:objectObjectHashMap.keySet()){
            System.out.println(objectObjectHashMap.get(key));
        }

//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//        }

        for(Map.Entry<Object,Object> ennty:objectObjectHashMap.entrySet()){
            System.out.println(ennty.getKey());
            System.out.println(ennty.getValue());
        }


        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        stringStringConcurrentHashMap.put("","");

        String[] str = new String[] { "yang", "hao" };
        List list = Arrays.asList(str);
        //list.add("yangguanbao");
        str[0] = "changed";
        System.out.println(list);

       list.addAll(null);


        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);








    }


    public static String getIp(String ipString){
        String regEx="((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(ipString);
        while (m.find()) {
            String result = m.group();
            return result;
        }
        return null;
    }
}
