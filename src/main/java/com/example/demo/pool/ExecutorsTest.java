package com.example.demo.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author fjl
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(3,
                        20, 60,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(10),
                        //AbortPolicy 拒绝策略
                        namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
    }
}
