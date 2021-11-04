package com.city.callabledemo;

import com.city.threadpoolexecutor.MyRejected;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: GuanBin
 * @date: Created in 下午11:19 2019/10/31
 */
public class TestCallable implements Callable<Object> {

    private int taskNum;

    public TestCallable(int taskNum) {
        this.taskNum = taskNum;
    }
    //1，2主要区别是创建线程的方式
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
       // test2();

    }

    /**
     * 使用Executors.newFixedThreadPool创建线程池
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void test1() throws InterruptedException, ExecutionException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize=5;
      // ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, 				//coreSize
                10, 				//MaxSize
                60, 			//60
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3)			//指定一种队列 （有界队列）
                //new LinkedBlockingQueue<Runnable>()
                , new MyRejected()
                //, new DiscardOldestPolicy()
        );

        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new TestCallable(i);
            // 执行任务并获取Future对象
            Future f = pool.submit(c);

            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString()); //OPTION + return 抛异常
        }
        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
    }

    /**
     * 线程直接使用new Thread来创建
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void test2() throws ExecutionException, InterruptedException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize=5;
        FutureTask[] randomNumberTasks = new FutureTask[5];
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < randomNumberTasks.length; i++) {
            Callable c = new TestCallable(i);
            // 执行任务并获取Future对象
            randomNumberTasks[i]=   new FutureTask(c);

            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        // 获取所有并发任务的运行结果
        for (Future f : randomNumberTasks) {
            // 从Future对象上获取任务的返回值，并输
            System.out.println(">>>" + f.get().toString()); //OPTION + return 抛异常
        }
        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");

    }

    /**
     * call方法的实现，主要用于执行线程的具体实现，并返回结果
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}