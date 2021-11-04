package com.city.threadlocal;

public class ThreadLocalTest {
   static final ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    static final ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
               // t.threadLocals = new ThreadLocalMap(this, firstValue); this 就是调用的set 方法的值也就是threadLocal1
                threadLocal1.set("A");
                threadLocal2.set(1);
                //threadLocal1.set("1");
//                threadLocal1.set(null);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(threadLocal1.get());
                System.out.println(threadLocal2.get());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set("B");
                threadLocal2.set(2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(threadLocal1.get());
                System.out.println(threadLocal2.get());
            }
        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println(threadLocal1.get());
//                System.out.println(threadLocal2.get());
//            }
//        }).start();
    }
}