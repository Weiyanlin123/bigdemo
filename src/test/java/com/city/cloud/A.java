package com.city.cloud;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class A {

    //线程安全
    private static ConcurrentHashMap<String, Object> onlineStatMap =  new ConcurrentHashMap<>();
    public static Map<String, Object> getOnlineStatMap() {
        return onlineStatMap;
    }
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    public static void getFinalResult() {
       if(onlineStatMap==null){
           ConcurrentHashMap<String, Object> objectObjectHashMap = new ConcurrentHashMap<>();
           objectObjectHashMap.put("1","1");
           onlineStatMap=objectObjectHashMap;
       }else {
           ConcurrentHashMap<String, Object> objectObjectHashMap = new ConcurrentHashMap<>();
           objectObjectHashMap.put("2","2");
           onlineStatMap=objectObjectHashMap;
       }

    }


    public static void main(String[] args) {

//        try {
//            String endpoint ="http://127.0.0.1:8884/hxyw/services/smsService?wsdl";
//            Service service = new Service();
//            Call call = null;
//            call =(Call) service.createCall();
//            call.setOperationName(new QName("http://127.0.0.1:8884/hxyw/services/smsService?wsdl","sendSm"));
//            call.setTargetEndpointAddress(new java.net.URL(endpoint));
//            call.setUseSOAPAction(true);
//            //2020-12-21 16:43:23
//            String obj= (String)call.invoke(new Object[]{"17621257791","最新测试222","","22"});
//            System.out.println("return value is " + obj);
//
//        } catch (Exception e) {
//            System.out.println("异常:"+e.toString());
//        }
//
//        System.out.println(getNonce_str());

//        for(int i=0;i<3;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            test();
//        }

        String beginTime = "2018-07-30 14:42:32";
        String endTime = "2018-07-29 12:26:32";

        SimpleDateFormat aaaaaaaa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date1 = aaaaaaaa.parse(beginTime);
            Date date2 = aaaaaaaa.parse(endTime);

            boolean before = date1.before(date2);

            System.out.println(before);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static void test() {
        new Thread(()->{
            getFinalResult();
            System.out.println(Thread.currentThread().getName()+"=============="+ A.getOnlineStatMap());

        }).start();

        new Thread(()->{
            getFinalResult();
            System.out.println(Thread.currentThread().getName()+"=============="+A.getOnlineStatMap());

        }).start();

        new Thread(()->{
            getFinalResult();
            System.out.println(Thread.currentThread().getName()+"=============="+A.getOnlineStatMap());

        }).start();
//
        threadPoolExecutor.execute(()->{
            getFinalResult();

            System.out.println(Thread.currentThread().getName()+"=============="+A.getOnlineStatMap());
        });
    }


    public static String getNonce_str() {
        String SYMBOLS = "0123456789";
        Random RANDOM = new SecureRandom();
        // 如果需要4位，那 new char[4] 即可，其他位数同理可得
        char[] nonceChars = new char[6];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }

}
