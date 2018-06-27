package com.example.demo.pool;

import java.util.concurrent.*;

public class MyTask implements Runnable{
    public MyTask() {
    }

    private String name;
    public MyTask(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+"" +
                "Thread Id:"+Thread.currentThread().getId());
       /* try {
            Thread.sleep(1000);
            System.out.println("sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
       /* ExecutorService service = Executors.newFixedThreadPool(5);
        MyTask myTask = new MyTask();
        for (int i = 0; i < 10; i++) {
            //有返回值
            //service.submit(myTask);
            service.execute(myTask);
        }*/
       //scheduled();
        pool();
    }
    public static void scheduled(){
        MyTask myTask = new MyTask();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        /**
         * 如果前面的任务没有完成，则调度不会启动
         * 上一个任务完成之后每隔2秒执行一次任务
         */
        executorService.
                scheduleWithFixedDelay(myTask,0,2,TimeUnit.SECONDS);
    }


    public static void pool(){
        ExecutorService executorService=new ThreadPoolExecutor(5,
                5,0L,TimeUnit.SECONDS
            ,new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                //在执行之前要做的事情
                System.out.println("执行任务之前"+((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                //在执行之后要做的事情
                System.out.println("执行任务之后"+((MyTask)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        for (int i = 0; i <10 ; i++) {
            MyTask myTask = new MyTask("Task" + i);
            executorService.execute(myTask);
        }
        executorService.shutdown();
    }
}
