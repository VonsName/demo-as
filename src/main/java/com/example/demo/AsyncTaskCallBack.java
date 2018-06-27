package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author ASUS
 */
@Component
public class AsyncTaskCallBack extends AbstractTask {
    /**
     * 指定线程池的名字
     * @return
     */
    @Async("taskExecutor")
    public Future<String> taskOne() {
        super.task1();
        System.out.println("当前任务1"+Thread.currentThread().getName());
        return new AsyncResult<>("任务1完成");
    }

    @Async("taskExecutor")
    public Future<String> task2Two() {
        super.task2();
        System.out.println("当前任务2"+Thread.currentThread().getName());
        return new AsyncResult<>("任务2完成");
    }

    @Async("taskExecutor")
    public Future<String> taskThree() {
        super.task3();
        System.out.println("当前任务3"+Thread.currentThread().getName());
        return new AsyncResult<>("任务3完成");
    }
}
