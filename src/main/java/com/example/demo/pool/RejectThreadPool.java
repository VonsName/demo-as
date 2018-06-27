package com.example.demo.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author ASUS
 */
public class RejectThreadPool {

    /**
     * 递归任务
     */
    public static class CountTask extends RecursiveTask<Integer> {
        @Override
        protected Integer compute() {
            return null;
        }
    }
    public static void main(String[] args) {
        ForkJoinPool joinPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = joinPool.submit(new CountTask());
        try {
            Integer integer = result.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
