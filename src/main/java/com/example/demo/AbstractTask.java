package com.example.demo;

/**
 * @author ASUS
 */
public abstract class AbstractTask {
    public void task1(){
        long start = System.currentTimeMillis();
        System.out.println("开始task1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(start-end+("---结束task1"));
    }
    public void task2(){
        long start = System.currentTimeMillis();
        System.out.println("开始task2");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(start-end+("---结束task2"));
    }
    public void task3(){
        long start = System.currentTimeMillis();
        System.out.println("开始task3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(start-end+("---结束task3"));
    }
}
