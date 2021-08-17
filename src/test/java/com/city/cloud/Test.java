package com.city.cloud;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    List<String> filedNames = Arrays.asList("name","age");
     
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }
     
    public long getLong() {
        return longLocal.get();
    }
     
    public String getString() {
        return stringLocal.get();
    }
     
    public static void main(String[] args) throws Exception {
     //   final Test test = new Test();
         
//
//        test.set();
//        System.out.println(test.getLong());
//        System.out.println(test.getString());
//
//
//        Thread thread1 = new Thread(){
//            public void run() {
//                test.set();
//                System.out.println(test.getLong());
//                System.out.println(test.getString());
//            };
//        };
//        thread1.start();
//        thread1.join();
//
//        Thread thread2 = new Thread(){
//            public void run() {
//                test.set();
//                System.out.println(test.getLong());
//                System.out.println(test.getString());
//            };
//        };
//        thread2.start();
//        thread2.join();


//
//        System.out.println(test.getLong());
//        System.out.println(test.getString());
//        Test test1 = new Test();
//
//        test1.test9();

        String s="asdasd";

        long milliSecond = 1551798059000L;
        Date date = new Date();
        date.setTime(milliSecond);
        System.out.println(date);


    }



    public void test9() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        Student student = new Student();


        System.out.println("student before" + student.getName());

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

            String name = propertyDescriptor.getName();
            if(filedNames.contains(name)){
            }
            System.out.println("name: " + name);
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (writeMethod == null) {
                continue;
            }
            Class<?>[] parameterTypes = writeMethod.getParameterTypes();

            for (Class<?> parameterType : parameterTypes) {
                parameterType.getName();
            }
            System.out.println(writeMethod.getName());
            if(writeMethod.getName().equals("setName")){
                writeMethod.invoke(student, "Bob");
            }
        }
        System.out.println("student after" + student.getName());

    }


}