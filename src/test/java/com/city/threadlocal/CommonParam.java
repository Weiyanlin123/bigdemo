package com.city.threadlocal;

import com.city.testLinked.Main;
import lombok.Data;

import java.util.Date;

@Data
public class CommonParam {
    private static ThreadLocal<CommonParam> threadLocal = new ThreadLocal<CommonParam>();
    private String mobile;
    private Long accountId;
    private Date beginTime;
    private String requestUrl;

    public static CommonParam getInstance() {
        //每个线程对应一个实例
        CommonParam param = threadLocal.get();
        if (param == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            param = new CommonParam();
            threadLocal.set(param);
        }
        return param;
    }

    public static void remove() {
        threadLocal.remove();
    }


    public static void main(String[] args) {

        /**
         *
         */
        


        new Thread(new Runnable() {
            @Override
            public void run() {
                CommonParam instance = CommonParam.getInstance();
                instance.setAccountId(111111111111L);
                System.out.println(instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                CommonParam instance = CommonParam.getInstance();
                 instance.setAccountId(2L);
                System.out.println(instance);
            }
        }).start();


    }
}
