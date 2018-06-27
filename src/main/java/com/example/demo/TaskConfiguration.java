package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ASUS
 * 线程池
 */
@Configuration
public class TaskConfiguration {
    @Bean(value = "taskExecutor")
    public Executor executor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(5);
        //最大线程数
        executor.setMaxPoolSize(20);
        //缓冲执行任务队列
        executor.setQueueCapacity(50);
        //允许的线程空闲时间
        executor.setKeepAliveSeconds(60);
        //线程的名字前缀
        executor.setThreadNamePrefix("taskExecutor-");
        //线程池对拒绝任务的处理策略
        /**
         * CallerRunsPolicy 当线程池没有处理能力的时候，该策略会在
         * execute方法的调用线程中执行被拒绝的任务；如果执行程序被关闭，
         * 则会丢弃该任务
         */

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
