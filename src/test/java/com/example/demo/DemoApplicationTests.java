package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private AsyncTaskCallBack asyncTaskCallBack;
    @Test
    public void contextLoads() {
        long start=System.currentTimeMillis();
        Future<String> taskOne = asyncTaskCallBack.taskOne();
        Future<String> task2Two = asyncTaskCallBack.task2Two();
        Future<String> taskThree = asyncTaskCallBack.taskThree();
        while (!taskOne.isDone()||!task2Two.isDone()||!taskThree.isDone()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("全部任务完成耗时"+(start-end));
    }
}
