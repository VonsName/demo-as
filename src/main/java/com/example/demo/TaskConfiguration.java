package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ASUS
 * 任务线程池
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

        /**
         * 线程池对拒绝任务的处理策略
         * CallerRunsPolicy 当线程池没有处理能力的时候，该策略会在
         * execute方法的调用线程中执行被拒绝的任务；如果执行程序被关闭，
         * 则会丢弃该任务
         */

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /**
         * 线程池关闭的时候等待所有任务都完成之后才销毁其他bean对象
         */
        executor.setWaitForTasksToCompleteOnShutdown(true);
        /**
         * 设置线程池中任务的等待时间
         * 如果超过这个时间，线程池会强制关闭，避免被阻塞
         */
        executor.setAwaitTerminationSeconds(60);
        return executor;
    }
}
