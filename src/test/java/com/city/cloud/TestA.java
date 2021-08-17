package com.city.cloud;

import com.citycloud.dcm.street.param.Source;

import java.util.HashMap;

public class TestA extends  HashMap {
    public static void main(String[] args) {
        TestA  stringObjectHashMap = (TestA) new TestA();
        stringObjectHashMap.put("","");

        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
//        System.out.println(d1==c);
//        System.out.println(e==f);

//        for(int binCount = 0; ; ++binCount){
//            b=b+1;
//            System.out.println(binCount);
//
//        }

        int m=0;
//        while (m<10){
//            System.out.println(m);
//            m=m+1;
//        }

//     do{
//         System.out.println(m);
//         m=m+1;
//     }
//     while(m<10);


        while (true){
            for(int i=0;i<10;i++){
                if(i==4){
                    try {
                        int v=i/0;
                        System.out.println(v);
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println(i);
            }
            System.out.println("结束=======================");
            break;
        }

        System.out.println("结束11111111=======================");


    }




}
